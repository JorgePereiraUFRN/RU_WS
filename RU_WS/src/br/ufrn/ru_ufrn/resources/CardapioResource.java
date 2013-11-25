package br.ufrn.ru_ufrn.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ufrn.ru_ufrn.controllers.ComentarioController;
import br.ufrn.ru_ufrn.mock.ComentarioMock;
import br.ufrn.ru_ufrn.mock.MockCardapio;
import br.ufrn.ru_ufrn.model.Alimento;
import br.ufrn.ru_ufrn.model.Cardapio;

@Path("cardapio")
public class CardapioResource {

	
	
	@GET
	public String publish() {
		return "Estou funcionando";
	}
	
	@GET
	@Path("hoje")
	@Produces(MediaType.APPLICATION_JSON)
	public Cardapio cardapioDoDia() {
		
		return MockCardapio.mock();
	}
	

}
