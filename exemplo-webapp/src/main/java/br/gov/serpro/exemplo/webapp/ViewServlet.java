package br.gov.serpro.exemplo.webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.gov.framework.demoiselle.core.context.ContextLocator;
import br.gov.framework.demoiselle.core.layer.IViewController;
import br.gov.framework.demoiselle.core.layer.integration.Injection;
import br.gov.serpro.exemplo.webapp.bean.Contato;
import br.gov.serpro.exemplo.webapp.bean.Pessoa;

public class ViewServlet extends HttpServlet implements IViewController {

	private static final long serialVersionUID = 1L;
	
	@Injection(name="1")
	Session session1;
	
	@Injection(name="2")
	Session session2;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		System.out.println(session1);
		System.out.println(session2);
		
		Contato contato = new Contato();
		contato.setNome("nome "+System.currentTimeMillis());
		contato.setTelefone("["+System.currentTimeMillis()+"]");
		
		session1.save(contato);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("nome "+System.currentTimeMillis());
		pessoa.setTelefone(null);
		
		session2.save(pessoa);
	}
	
}
