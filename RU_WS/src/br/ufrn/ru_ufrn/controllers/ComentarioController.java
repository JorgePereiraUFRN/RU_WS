package br.ufrn.ru_ufrn.controllers;

import br.ufrn.ru_ufrn.model.Comentario;

public interface ComentarioController {
	
	public Comentario[] getComentarios();

	public void postarComentario(Comentario comentario);
	
	
}
