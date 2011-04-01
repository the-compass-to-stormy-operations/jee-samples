package br.gov.serpro.exemplo.jee5.impl;

import javax.ejb.Stateless;

import br.gov.serpro.exemplo2.jee5.ejb.Exemplo2Local;

@Stateless
public class Exemplo2LocalImpl implements Exemplo2Local {

	public void sayHello() {
		System.out.println("Exemplo2LocalImpl hello");
	}

}
