package br.gov.serpro.exemplo.jee5.impl;

import javax.ejb.Stateless;

import br.gov.serpro.exemplo.jee5.ejb.ExemploRemote;

@Stateless
public class ExemploRemoteImpl implements ExemploRemote {

	public void sayHello() {
		System.out.println("ExemploRemoteImpl hello");
	}

}
