package tirando.onda.jee.jee5.utility.config;

public class ConfigurationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 */
    public ConfigurationException() {
    	super();
    }
    
    /**
     * Constructor with message
     * 
     * @param message message of exception
     */
    public ConfigurationException(String message) {
    	super(message);
    }

    /**
     * Constructor with message and cause
     * 
     * @param message message of exception
     * @param cause cause of exception
     */
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

}
