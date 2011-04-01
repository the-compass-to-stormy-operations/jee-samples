package br.gov.serpro.exemplo.jee5.impl;

import javax.ejb.Stateless;
import javax.security.jacc.PolicyContext;

import br.gov.serpro.exemplo2.jee5.ejb.Exemplo2Remote;

@Stateless
public class Exemplo2RemoteImpl implements Exemplo2Remote {
	
	public void sayHello() {
		System.out.println("Exemplo2RemoteImpl hello");
		
		System.out.println(PolicyContext.getHandlerKeys());
	}

}
