package br.gov.serpro.exemplo.jee5.web;

import javax.ejb.EJB;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import br.gov.serpro.exemplo.jee5.ejb.ExemploLocal;
import br.gov.serpro.exemplo2.jee5.ejb.Exemplo2Remote;

public class ExemploRequestListener implements ServletRequestListener {
	
	@EJB
	ExemploLocal exemplo;
	
	@EJB
	Exemplo2Remote exemplo2;
	
	public void requestInitialized(ServletRequestEvent sre) {
		
		
//		try {
//			InitialContext ctx = new InitialContext();
//			
//			UserTransaction trx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
//			System.out.println(trx.getStatus());
//			trx.begin();
//			System.out.println(trx.getStatus());
//			
//			TransactionSynchronizationRegistry registry = (TransactionSynchronizationRegistry) ctx.lookup("java:comp/TransactionSynchronizationRegistry");
//			registry.putResource("teste", "xyz");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		System.out.println(PolicyContext.getContextID());
//		System.out.println(PolicyContext.getHandlerKeys());
//		
//		PolicyContext.setHandlerData("sadadasd");
//		
//		
//		try {
//			Object object = PolicyContext.getContext("String.Value");
//			System.out.println(object);
//		} catch (PolicyContextException e) {
//			e.printStackTrace();
//		}
		
		exemplo.sayHello();
		
		exemplo2.sayHello();
	}

	public void requestDestroyed(ServletRequestEvent sre) {
//		try {
//			InitialContext ctx = new InitialContext();
//			
//			UserTransaction trx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
//			trx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
