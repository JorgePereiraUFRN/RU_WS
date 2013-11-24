package br.ufrn.ru_ufrn.mock;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.ru_ufrn.controllers.ComentarioController;
import br.ufrn.ru_ufrn.model.Comentario;

public class ComentarioMock implements ComentarioController{
	
	private static final List<Comentario> comentarios = java.util.Collections.synchronizedList(new ArrayList<Comentario>());

	
	public ComentarioMock(){
		
		Comentario c1 = new Comentario();
		c1.setComentario("comentario 1");
		c1.setIdComentario(0);
		c1.setIdUsuario(0);
		c1.setImagem("imagem 1");
		c1.setUsuario("user 1");
		
		comentarios.add(c1);
		
		Comentario c2 = new Comentario();
		c1.setComentario("comentario 2");
		c1.setIdComentario(1);
		c1.setIdUsuario(1);
		c1.setImagem("imagem 2");
		c1.setUsuario("user 2");
		
		comentarios.add(c2);
		
		
		
	}
	
	@Override
	public Comentario[] getComentarios() {
		
		return comentarios.toArray(new Comentario[comentarios.size()]);
	}

	@Override
	public void postarComentario(Comentario comentario) {
		if(comentario != null && comentario.getComentario() != null 
				&& comentario.getUsuario() != null)
			
		comentarios.add(comentario);
		
	}

}
