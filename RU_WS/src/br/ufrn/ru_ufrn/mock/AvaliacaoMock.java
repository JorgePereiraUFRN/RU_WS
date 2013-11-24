package br.ufrn.ru_ufrn.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import java.util.concurrent.atomic.AtomicInteger;

import br.ufrn.ru_ufrn.controllers.AvaliacaoController;
import br.ufrn.ru_ufrn.model.Avaliacao;
import br.ufrn.ru_ufrn.model.AvaliacaoItem;
import br.ufrn.ru_ufrn.model.ResultadoAvItem;
import br.ufrn.ru_ufrn.model.ResultadoAvaliacoes;

public class AvaliacaoMock implements AvaliacaoController{
	
	//chave de avaliaoes data+idRefeicao+idUser
	private static final Map<String, Avaliacao> avaliacoes = Collections.synchronizedMap(new HashMap<String, Avaliacao>() );
	
	//chave de avItens data+idRefeicao+item+idUser
	private static final Map<String, List<AvaliacaoItem>> avItens = Collections.synchronizedMap(new HashMap<String, List<AvaliacaoItem>>() );

	private static final AtomicInteger idAvaliacao = new AtomicInteger(0);
	
	private static final AtomicInteger idAvItem = new AtomicInteger(0);
	
	@Override
	public Avaliacao getavaliacao(String data, int idRefeicao, int idUser) {
		if(data != null ){
		
		return avaliacoes.get(data+idRefeicao);
		}
		
		return null;
	}

	/*@Override
	public AvaliacaoItem getAvItem(String data, int idRefeicao, String item) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public void avaliarCardapio(Avaliacao avaliacao) {
		
		if(avaliacao.getData() != null ){
			avaliacao.setIdAvaliacao(idAvaliacao.getAndIncrement());
			
			avaliacoes.put(avaliacao.getDataFormatoAmericano()+avaliacao.getIdAvaliacao(), avaliacao);
		}
		
	}

	@Override
	public void avaliarItem(AvaliacaoItem avItem) {
		
		if(avItem.getData() != null){
			
			if( avItens.get(avItem.getDataFormatoAmericano()+avItem.getIdAvaliacao()) == null){
				
				avItens.put(avItem.getDataFormatoAmericano()+idAvItem.getAndIncrement(), new ArrayList<AvaliacaoItem>());	
			}
			
			avItens.get(avItem.getDataFormatoAmericano()+avItem.getIdAvaliacao()).add(avItem);
			
		}
		
	}

	@Override
	public void atualizaAvCardapio(Avaliacao avaliacao, int idUser,
			int idRefeicao, String data) {
		
		
		
	}

	@Override
	public void atualizarAVItem(AvaliacaoItem avItem, int idUser,
			int idRefeicao, String data, String item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultadoAvaliacoes resultadoAvaliacoes(int idRefeicao, String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoAvItem[] getresultadoAvItem(int idRefeicao, String data) {
		// TODO Auto-generated method stub
		return null;
	}

}
