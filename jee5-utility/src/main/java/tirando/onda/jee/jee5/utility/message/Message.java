package tirando.onda.jee.jee5.utility.message;

import java.util.Locale;

public interface Message {

	public String getKey();

	public String getLabel();

	public Locale getLocale();

	public Severity getSeverity();

	public String getResourceName();

}
