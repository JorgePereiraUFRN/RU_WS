package br.ufrn.ru_ufrn.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.ufrn.ru_ufrn.controllers.AvaliacaoController;
import br.ufrn.ru_ufrn.model.Avaliacao;
import br.ufrn.ru_ufrn.model.AvaliacaoItem;
import br.ufrn.ru_ufrn.model.NivelSatisfacao;
import br.ufrn.ru_ufrn.model.ResultadoAvItem;
import br.ufrn.ru_ufrn.model.ResultadoAvaliacoes;

public class AvaliacaoMock implements AvaliacaoController{
	
	//chave de avaliaoes data+refeicao+idUser
	private static final Map<String, Avaliacao> avaliacoes = Collections.synchronizedMap(new HashMap<String, Avaliacao>() );
	
	//chave de avItens data+refeicao+item
	private static final Map<String, List<AvaliacaoItem>> avItens = Collections.synchronizedMap(new HashMap<String, List<AvaliacaoItem>>() );

	
	public AvaliacaoMock(){
		
		Avaliacao av1 = new Avaliacao();
		av1.setCardapioCumprido(false);
		av1.setData(new Date());
		av1.setId(0);
		av1.setIdAvaliacao(2);
		av1.setIdRefeicao(2);
		av1.setIdUsuario(0L);
		av1.setRefeicao(av1.ALMOCO_CARNIVORO);
		
		avaliarCardapio(av1);
		
		
		AvaliacaoItem avi = new AvaliacaoItem();
		avi.setData(new Date());
		avi.setIdAvaliacao(1L);
		avi.setIdUsuario(1L);
		avi.setItem("frango seco");
		avi.setNivelSatisfacao(NivelSatisfacao.DESGOSTEI);
		avi.setRefeicao(avi.ALMOCO_CARNIVORO);
		
		avaliarItem(avi);
		
		
	}

	
	@Override
	public Avaliacao getavaliacao(String data, String refeicao, int idUser) {
		if(data != null ){
		
		return avaliacoes.get(data+refeicao+idUser);
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
			
			
			avaliacoes.put(avaliacao.getDataFormatoAmericano()+avaliacao.getRefeicao()+avaliacao.getIdUsuario(), avaliacao);
		}
		
	}

	@Override
	public void avaliarItem(AvaliacaoItem avItem) {
		
		if(avItem.getData() != null){
			
			if( avItens.get(avItem.getDataFormatoAmericano()+avItem.getRefeicao()+avItem.getItem()) == null){
				
				avItens.put(avItem.getDataFormatoAmericano()+avItem.getRefeicao()+avItem.getItem(), new ArrayList<AvaliacaoItem>());	
			}
			
			avItens.get(avItem.getDataFormatoAmericano()+avItem.getRefeicao()+avItem.getItem()).add(avItem);
			
		}
		
	}

	@Override
	public void atualizaAvCardapio(Avaliacao avaliacao, int idUser,
			String refeicao, String data) {
		
		if(avaliacao.getData() != null ){
			
			avaliacoes.remove(avaliacao.getDataFormatoAmericano()+avaliacao.getRefeicao()+avaliacao.getIdUsuario());
			
			avaliacoes.put(avaliacao.getDataFormatoAmericano()+avaliacao.getRefeicao()+avaliacao.getIdUsuario(), avaliacao);
		}
		
	}

	@Override
	public void atualizarAVItem(AvaliacaoItem avItem, int idUser,
			String refeicao, String data, String item) {
		
		if(avItem.getData() != null){
			
			if( avItens.get(avItem.getDataFormatoAmericano()+avItem.getRefeicao()+avItem.getItem()) != null){
				
				List<AvaliacaoItem> avaliacoes = avItens.get(avItem.getDataFormatoAmericano()+avItem.getRefeicao()+avItem.getItem());
				
				for( AvaliacaoItem avI : avaliacoes){
					
					if(avI.getData().equals(data) && avI.getIdUsuario() == idUser
							&& avI.getRefeicao().equals(refeicao) && avI.getItem().equals(item)){
						
						avI = avItem;
						break;	
					}
					
				}
			}
			
			
			
		}
		
	}

	@Override
	public ResultadoAvaliacoes resultadoAvaliacoes(String refeicao, String data) {
		
		Iterator<Avaliacao> avs = avaliacoes.values().iterator();
		
		ResultadoAvaliacoes result = new ResultadoAvaliacoes();
		result.setData(new Date(data));
		result.setDesgostaram(0);
		result.setGostaram(0);
		result.setIndiferente(0);
		result.setTotaVotos(0);
		result.setRefeicao(refeicao);
		result.setCardapioCumprido(0);
		result.setCardapioDescumprido(0);
		
		Avaliacao avaliacao = null;
		while(avs.hasNext()){
			avaliacao = avs.next();
			
			if(refeicao.equals(avaliacao.getRefeicao()) && avaliacao.getDataFormatoAmericano().equals(data)){
				
				if(avaliacao.getCardapioCumprido()){
					result.setCardapioCumprido(result.getCardapioCumprido() + 1);
				}else{
					result.setCardapioDescumprido(result.getCardapioDescumprido() + 1);
				}
				
				if(avaliacao.getIdAvaliacao() == 1){
					result.setGostaram(result.getGostaram() + 1);
				}
				else if(avaliacao.getIdAvaliacao() == 2){
					result.setDesgostaram(result.getGostaram() + 1 );
				}
				else{
					result.setIndiferente(result.getIndiferente() + 1);
				}
				
				
				
			}
		}
		
		result.setTotaVotos(result.getGostaram() + result.getDesgostaram() + result.getIndiferente());
		
		
		return result;
		
	}

	@Override
	public ResultadoAvItem[] getresultadoAvItem(String refeicao, String data) {
		
		List<ResultadoAvItem> resultList = new ArrayList<ResultadoAvItem>();
		
		Iterator<List<AvaliacaoItem>> avaliacoes = avItens.values().iterator();
		
		List<AvaliacaoItem> avs = null;
		
		while(avaliacoes.hasNext()){
			avs = avaliacoes.next();
			
			if(avs != null){
				
				ResultadoAvItem r = new ResultadoAvItem();
				r.setItem(avs.get(0).getItem());
				r.setData(avs.get(0).getData());
				r.setRefeicao(refeicao);
				
				r.setDesgostaram(0);
				r.setGostaram(0);
				r.setIndiferente(0);
				
				for(AvaliacaoItem avi : avs){
					if(avi.getRefeicao().equals(refeicao) && avi.getDataFormatoAmericano().equals(data)){
						
						if(avi.getNivelSatisfacao().toString().equals(NivelSatisfacao.GOSTEI.toString())){
							r.setGostaram(r.getGostaram() + 1);
						}
						else if(avi.getNivelSatisfacao().toString().equals(NivelSatisfacao.DESGOSTEI.toString())){
							r.setDesgostaram(r.getDesgostaram() + 1);
						}
						else{
							r.setIndiferente(r.getIndiferente() + 1);
						}
						
						
					}
					
					
				}
				
				r.setTotalVotos(r.getGostaram() + r.getDesgostaram() + r.getIndiferente());
				
				resultList.add(r);
			}
			
		}
		
 		
		
		return resultList.toArray(new ResultadoAvItem[resultList.size()]);
	}

}
