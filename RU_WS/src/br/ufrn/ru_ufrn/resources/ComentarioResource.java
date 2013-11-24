package br.ufrn.ru_ufrn.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ufrn.ru_ufrn.model.Comentario;

@Path("comentario")
public class ComentarioResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Comentario[] getComentarios(){
		Comentario[] comentarios= null;
		
		return comentarios;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void postarComentario(Comentario comentario){
		
	}

}
