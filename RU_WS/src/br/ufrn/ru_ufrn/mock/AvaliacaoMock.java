package br.ufrn.ru_ufrn.mock;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;




import br.ufrn.ru_ufrn.controllers.AvaliacaoController;
import br.ufrn.ru_ufrn.model.Avaliacao;
import br.ufrn.ru_ufrn.model.AvaliacaoItem;
import br.ufrn.ru_ufrn.model.ResultadoAvItem;
import br.ufrn.ru_ufrn.model.ResultadoAvaliacoes;

public class AvaliacaoMock implements AvaliacaoController{
	
	static final Map<String, Avaliacao> avaliacoes = Collections.synchronizedMap(new HashMap<String, Avaliacao>() );
	static final Map<String, AvaliacaoItem> avItens = Collections.synchronizedMap(new HashMap<String, AvaliacaoItem>() );

	@Override
	public Avaliacao getavaliacao(String data, int idRefeicao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvaliacaoItem getAvItem(String data, int idRefeicao, String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void avaliarCardapio(Avaliacao avaliacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avaliarItem(AvaliacaoItem avItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizaAvCardapio(Avaliacao avaliacao, int idUser,
			int idRefeicao, String data) {
		// TODO Auto-generated method stub
		
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
