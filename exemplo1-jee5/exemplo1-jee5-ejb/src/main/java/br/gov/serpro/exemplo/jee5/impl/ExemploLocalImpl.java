package br.gov.serpro.exemplo.jee5.impl;

import javax.ejb.Stateless;
import javax.security.jacc.PolicyContext;
import javax.security.jacc.PolicyContextException;

import br.gov.serpro.exemplo.jee5.ejb.ExemploLocal;

@Stateless
public class ExemploLocalImpl implements ExemploLocal {

	public void sayHello() {
		System.out.println("ExemploLocalImpl hello");
		
		try {
			Object object = PolicyContext.getContext("String.Value");
			System.out.println(object);
		} catch (PolicyContextException e) {
			e.printStackTrace();
		}
	}

}
