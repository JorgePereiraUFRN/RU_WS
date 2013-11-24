package br.ufrn.ru_ufrn.resources;


import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.ufrn.ru_ufrn.controllers.ComentarioController;
import br.ufrn.ru_ufrn.mock.ComentarioMock;
import br.ufrn.ru_ufrn.model.Comentario;

@Path("comentario")
public class ComentarioResource {
	
	
	private static final ComentarioController COM_CONTROLLER = new ComentarioMock();
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Comentario[] getComentarios(){
		Comentario[] comentarios= COM_CONTROLLER.getComentarios();
		
		return comentarios;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void postarComentario(Comentario comentario){
		
		COM_CONTROLLER.postarComentario(comentario);
		
	}

	public static void main(String args[]){
		Date data = new Date(System.currentTimeMillis());
		
		System.out.println(data.toString());
		
		String dt = (data.getYear()+1900)+"-"+(data.getMonth()+1)+"-"+data.getDate();
		
		System.out.println(dt);
		
		String d[] = dt.split("-");
		
		int ano = Integer.parseInt(d[0]);
		int mes = Integer.parseInt(d[1]) - 1;
		int dia = Integer.parseInt(d[2]);
		
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(ano, mes , dia);
				
		System.out.println(calendar.getTime().toString());
	}
	
}
