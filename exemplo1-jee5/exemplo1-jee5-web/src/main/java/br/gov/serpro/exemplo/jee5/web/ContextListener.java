package br.gov.serpro.exemplo.jee5.web;

import javax.security.jacc.PolicyContext;
import javax.security.jacc.PolicyContextException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			PolicyContext.registerHandler(StringValuePolicyContextHandler.KEY, new StringValuePolicyContextHandler(), true);
			System.out.println("Registrou o handler...........................");
		} catch (PolicyContextException e) {
			e.printStackTrace();
		}
	}
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
