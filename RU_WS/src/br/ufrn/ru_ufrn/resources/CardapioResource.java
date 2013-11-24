package br.ufrn.ru_ufrn.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ufrn.ru_ufrn.model.Alimento;

@Path("cardapio")
public class CardapioResource {

	@GET
	public String publish() {
		return "Estou funcionando";
	}
	
	@GET
	@Path("/alimento")
	@Produces(MediaType.APPLICATION_JSON)
	public Alimento getAlimento() {
		Alimento teste = new Alimento();
		
		teste.setId(0);
		teste.setImagem("imagem");
		teste.setNome("nome");
		teste.setDescricao("descricao");
		return teste;
	}
	

}
