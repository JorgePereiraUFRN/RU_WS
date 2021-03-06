package br.ufrn.ru_ufrn.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Alimento extends Model {
	private String nome;
	private String descricao;
	private String imagem;
	
	public Alimento() {
		
	}

	public Alimento(String nome, String descricao, String imagem) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
}
