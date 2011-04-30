package tirando.onda.jee.jee5.library.config;

public enum ConfigType {
	
	/**
	 * Configuration loaded by {@link System#getProperties()} or {@link System#getenv()}
	 */
	SYSTEM,
	/**
	 * Configuration loaded by XML resources
	 */
	XML,
	/**
	 * Configuration loaded by PROPERTIES resources
	 */
	PROPERTIES;

}
