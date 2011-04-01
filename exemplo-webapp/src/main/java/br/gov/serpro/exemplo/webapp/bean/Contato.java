package br.gov.serpro.exemplo.webapp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "contato")
@SequenceGenerator(name = "sq_contato", sequenceName = "sq_contato")
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_contato")
	@Column(name = "id_contato")
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="telefone")
	private String telefone;

	public Contato() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
