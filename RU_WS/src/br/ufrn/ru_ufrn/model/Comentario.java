package br.ufrn.ru_ufrn.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comentario {
	
	private Integer idComentario;
	private Integer idUsuario;
	private String comentario;
	private String imagem;
	private String usuario;
	
	
	public Comentario(){
		
	}
	
	public Comentario(String cometario, String imagem, String usuario){
		this.comentario = cometario;
		this.imagem = imagem;
		this.usuario = usuario;
	}
	
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Integer getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	

}
