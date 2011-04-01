package br.gov.serpro.exemplo.jee5.web;

import javax.security.jacc.PolicyContextException;
import javax.security.jacc.PolicyContextHandler;

public class StringValuePolicyContextHandler implements PolicyContextHandler {
	
	public static final String KEY = "String.Value";
	
	public Object getContext(String key, Object data) throws PolicyContextException {
		if (key.equalsIgnoreCase(KEY) == true) {
			return data;
		} else {
			return null;
		}
	}

	public String[] getKeys() throws PolicyContextException {
		return new String[]{KEY};
	}

	public boolean supports(String key) throws PolicyContextException {
		return KEY.equals(key);
	}

}
