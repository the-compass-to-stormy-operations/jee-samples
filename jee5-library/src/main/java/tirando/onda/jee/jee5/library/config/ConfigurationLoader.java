package tirando.onda.jee.jee5.library.config;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.log4j.Logger;

public class ConfigurationLoader {
	
	private static Logger log = Logger.getLogger(ConfigurationLoader.class);

	private ConfigurationLoader() {}
	
	/**	
	 * Loads a config class filling it with the corresponding values.
	 * 
	 * @param object config object
	 * @throws ConfigurationException
	 */
	public static void load(Object object) throws ConfigurationException {
		load(object, null);
	}

	/**
	 * Loads a config class filling it with the corresponding values.
	 * 
	 * @param object config object
	 * @param resourceName resource name
	 * @throws ConfigurationException
	 */
	public static void load(Object object, String resourceName) throws ConfigurationException {
		
		log.debug("Loading values into configuration class " + object.getClass().getName());
		
		boolean useCache = true;
		
		Config config = object.getClass().getAnnotation(Config.class);
		if (config != null && !config.cache()) {
			useCache = false;
		}
		
		CacheManager cacheManager = CacheManager.getInstance();
		Cache cache = cacheManager.getCache("br.gov.framework.demoiselle.util.config");
		if (cache==null) {
			cache = new Cache("br.gov.framework.demoiselle.util.config", 10000, false, true, 120, 120);
			CacheManager.getInstance().addCache(cache);
		}
		
		Element element = null;
		if (useCache) {
			element = cache.get(object.getClass().getName());
		}
		
		if (element != null) {
			log.debug("From Cache...");
			
			Object objectInCache = element.getObjectValue();
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				try {
					Field fieldInCache = objectInCache.getClass().getDeclaredField(field.getName());
					
					if (!Modifier.isFinal(field.getModifiers())) {
						field.setAccessible(true);
						fieldInCache.setAccessible(true);
						
						field.set(object, fieldInCache.get(objectInCache));
					}
				} catch (Exception e) {
					throw new ConfigurationException("Error copying values from cache", e);
				}
			}
			
		} else {
			log.debug("From Object...");
			
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(ConfigKey.class)) {
					ConfigKey configKey = field.getAnnotation(ConfigKey.class);
					
					String name = configKey.name();
					Collection<String> vars = getVariables(name);
					
					if (vars != null && vars.size() > 0) {
						name = configKey.name();
						Map<String, String> valuesSubstitutor = new HashMap<String, String>();
						for (String interpolation : vars) {
							Configuration cfg = getConfiguration(configKey.resourceName(), configKey.type(), resourceName);
							String valueInterpolation = getValue(interpolation, cfg, String.class);
							
							if (valueInterpolation == null && configKey.defaultInSystem() && !configKey.type().equals(ConfigType.SYSTEM)) {
								cfg = getConfiguration(configKey.resourceName(), ConfigType.SYSTEM, resourceName);
								valueInterpolation = getValue(interpolation, cfg, String.class);
							}
							if (valueInterpolation == null) {
								throw new ConfigurationException("Interpolation name \""+interpolation+"\" not found ");
							}
							valuesSubstitutor.put(interpolation, valueInterpolation);
						}
						StrSubstitutor str = new StrSubstitutor(valuesSubstitutor);
						name = str.replace(name);
					} else {
						name = configKey.name();
					}
					
					Object keyValue = getKeyValue(field, name, configKey.resourceName(), configKey.type(), resourceName);
					
					if (keyValue == null && configKey.defaultInSystem() && !configKey.type().equals(ConfigType.SYSTEM)) {
						keyValue = getKeyValue(field, name, configKey.resourceName(), ConfigType.SYSTEM, resourceName);
					}
					
					if (keyValue == null && configKey.required()) {
						throw new ConfigurationException("Field "+field.getName()+" is mandatory");
					}
					
					if (keyValue != null) {
						try {
							field.setAccessible(true);
							field.set(object, keyValue);
						} catch (Exception e) {
							throw new ConfigurationException("Error loading configuration key '" + name + "'", e); 
						}
					}
				}
			}
			
			if (useCache) {
				cache.put(new Element(object.getClass().getName(), object));
			}
		}
	}
	
	/**
	 * Returns the value already associated with the specified field and resource.
	 * 
	 * @param field
	 * @param name
	 * @param resourceName
	 * @param type
	 * @param newResourceName
	 * @return	the value
	 */
	private static Object getKeyValue(Field field, String name, String resourceName, ConfigType type, String newResourceName) {

		log.debug("Loading key \"" + name + "\" into field \"" + field.getName() + "\"");

		Configuration cfg = getConfiguration(resourceName, type, newResourceName);
		Object keyValue = getValue(name, cfg, field.getType());

		return keyValue;		
	}

	/**
	 * Returns the configuration class according to specified resource name and configuration type.
	 * 
	 * @param resourceName
	 * @param type
	 * @param newResourceName
	 * @return	a configuration
	 */
	private static Configuration getConfiguration(String resourceName, ConfigType type, String newResourceName) {
		
		Configuration cfg;
		
		switch (type) {
		case SYSTEM:
			cfg = new SystemConfiguration();
			break;
		case PROPERTIES:
			String props = newResourceName == null ? resourceName : newResourceName;
			try {
				cfg = new PropertiesConfiguration(props);
			} catch (Exception e) {
				throw new ConfigurationException("Error creating configuration from resource " + props, e);
			}
			break;
		case XML:
			String xml = newResourceName == null ? resourceName : newResourceName;
			try {
				cfg = new XMLConfiguration(xml);
			} catch (Exception e) {
				throw new ConfigurationException("Error creating configuration from resource " + xml, e);
			}
			break;
		default:
			throw new ConfigurationException(type + " Not Implemented");
		}
		
		return cfg;		
	}
	
	/**
	 * Returns the value associated with the given configuration class and field type.
	 * 
	 * @param name
	 * @param cfg
	 * @param fieldType
	 * @return	the value
	 */
	@SuppressWarnings("unchecked")
	private static <T> T getValue(String name, Configuration cfg, Class<T> fieldType) {
		
		Object value;
		
		if (fieldType.equals(String.class)) {
			value = cfg.getString(name, null);
		} else if (fieldType.equals(Boolean.class) || fieldType.equals(Boolean.TYPE)) {
			value = cfg.getBoolean(name, null);
		} else if (fieldType.equals(Byte.class) || fieldType.equals(Byte.TYPE)) {
			value = cfg.getByte(name, null);
		} else if (fieldType.equals(Double.class) || fieldType.equals(Double.TYPE)) {
			value = cfg.getDouble(name, null);
		} else if (fieldType.equals(Float.class) || fieldType.equals(Float.TYPE)) {
			value = cfg.getFloat(name, null);
		} else if (fieldType.equals(Integer.class) || fieldType.equals(Integer.TYPE)) {
			value = cfg.getInteger(name, null);
		} else if (fieldType.equals(Long.class) || fieldType.equals(Long.TYPE)) {
			value = cfg.getLong(name, null);
		} else if (fieldType.equals(Short.class) || fieldType.equals(Short.TYPE)) {
			value = cfg.getShort(name, null);
		} else if (fieldType.equals(BigDecimal.class)) {
			value = cfg.getBigDecimal(name, null);
		} else if (fieldType.equals(BigInteger.class)) {
			value = cfg.getBigInteger(name, null);
		} else if (fieldType.equals(List.class)) {
			value = cfg.getList(name);
		} else if (fieldType.isArray() && fieldType.getComponentType().equals(String.class)) {
			value = cfg.getStringArray(name);
		} else if (fieldType.equals(Properties.class)) {
			value = null;
			Iterator<String> iterator = cfg.getKeys(name);
			if (iterator.hasNext()) {
				Properties props = new Properties();
				while (iterator.hasNext()) {
					String completeKey = iterator.next();
					String prefix = name + ".";
					String key = completeKey.substring(prefix.length());
					props.put(key, cfg.getString(completeKey));
				}					
				value = props;
			}
		} else {
			throw new ConfigurationException("Error converting to type " + fieldType.getName());
		}		
		
		return (T) value;
	}
	
	/**
	 * Returns a collection of variables available in the specified name.
	 * 
	 * @param name
	 * @return	the collection
	 */
	private static Collection<String> getVariables(String name) {
		
		char escape = '$';
		char prefix = '{';
		char suffix = '}';
		
		Collection<String> result = new HashSet<String>();
		boolean capture = false;
		StringBuilder str = null;
        for (int i = 0; i < name.length(); ++i) {
			char ch = name.charAt(i);
			if (ch == escape && name.charAt(i+1) == prefix) {
				i++;
				capture = true;
				str = new StringBuilder();
				continue;
			} else if (ch == suffix) {
				capture = false;
				result.add(str.toString());
			}
			
			if (capture) {
				str.append(ch);
			}
		}
		
		return result;
	}
	
	/**
	 * Loads a config object with its class as a parameter.
	 * 
	 * @param clazz
	 * @return	the instantiated class
	 */
	public static <T> T load(Class<T> clazz) throws ConfigurationException {
		return load(clazz, null);
	}

	/**
	 * Loads a config object with its class as a parameter.
	 * 
	 * @param clazz
	 * @param resourceName
	 * @return	the instantiated class
	 */
	public static <T> T load(Class<T> clazz, String resourceName) throws ConfigurationException {
		
		T object;
		try {
			object = clazz.newInstance();
		} catch (Exception e) {
			throw new ConfigurationException("Error creating a new instance for " +
					clazz.getName(), e); 
		}
		
		load(object, resourceName);
		
		return object;
	}
	
}
