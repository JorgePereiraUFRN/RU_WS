package br.ufrn.ru_ufrn.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.ufrn.ru_ufrn.controllers.AvaliacaoController;
import br.ufrn.ru_ufrn.mock.AvaliacaoMock;
import br.ufrn.ru_ufrn.model.Avaliacao;
import br.ufrn.ru_ufrn.model.AvaliacaoItem;
import br.ufrn.ru_ufrn.model.ResultadoAvItem;
import br.ufrn.ru_ufrn.model.ResultadoAvaliacoes;


@Path("cardapio")
public class AvaliacaoResource {
	
	private static AvaliacaoController avController = new AvaliacaoMock();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("avaliacao-cardapio/{refeicao}/{data}/{idUser}")
	public Avaliacao getavaliacao(@PathParam("data") String data, @PathParam("refeicao") String refeicao,
			@PathParam("idUser") int idUser){
		Avaliacao avaliacao = avController.getavaliacao(data, refeicao, idUser);
		
		return avaliacao;
	}
	
/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("avaliacao-item/{idRefeicao}/{data}/{item}")
	public AvaliacaoItem getAvItem(@PathParam("data") String data, @PathParam("refeicao") int idRefeicao,
			@PathParam("item") String item){
		AvaliacaoItem avitem = null;
		
		
		return avitem;
	}*/
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("avaliar-cardapio")
	public void avaliarCardapio(Avaliacao avaliacao){
		
		avController.avaliarCardapio(avaliacao);
		
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("avaliar-item")
	public void avaliarItem(AvaliacaoItem avItem){
		
		avController.avaliarItem(avItem);
		
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/atualizar-av-cardapio")
	public void atualizaAvCardapio(Avaliacao avaliacao,  @QueryParam("idUser") int idUser, 
			@QueryParam("refeicao") String refeicao, @QueryParam("data")String data){
		
		avController.atualizaAvCardapio(avaliacao, idUser, refeicao, data);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/atualizar-av-item")
	public void atualizarAVItem(AvaliacaoItem avItem , @QueryParam("idUser") int idUser, 
			@QueryParam("refeicao") String refeicao, @QueryParam("data")String data, 
			@QueryParam("item") String item){
		
		avController.atualizarAVItem(avItem, idUser, refeicao, data, item);
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/resultados-avaliacoes")
	public ResultadoAvaliacoes resultadoAvaliacoes(@QueryParam("refeicao") String refeicao, 
			@QueryParam("data") String data ){
		
		ResultadoAvaliacoes resAvaliacoes = avController.resultadoAvaliacoes(refeicao, data);
		
		return resAvaliacoes;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/resultados-av-itens")
	public ResultadoAvItem[] getresultadoAvItem(@QueryParam("refeicao") String refeicao, 
			@QueryParam("data") String data ){
		
		ResultadoAvItem avItens[] = avController.getresultadoAvItem(refeicao, data);
		
		return avItens;
	}
	
	
	

}
