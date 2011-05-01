package tirando.onda.jee.jee5.utility.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(value=ElementType.FIELD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface ConfigKey {

	/**
	 * Key configuration name
	 */
	public String name();
	
	/**
	 * Configuration type
	 */
	public ConfigType type() default ConfigType.PROPERTIES;
	
	/**
	 * Resource localization, if exists 
	 */
	public String resourceName() default "";
	
	/**
	 * Load value default from system 
	 */
	public boolean defaultInSystem() default false;
	
	/**
	 * value is required
	 */
	public boolean required() default false;
	
}
