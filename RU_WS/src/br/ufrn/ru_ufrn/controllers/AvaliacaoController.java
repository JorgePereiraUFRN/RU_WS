package br.ufrn.ru_ufrn.controllers;

import br.ufrn.ru_ufrn.model.Avaliacao;
import br.ufrn.ru_ufrn.model.AvaliacaoItem;
import br.ufrn.ru_ufrn.model.ResultadoAvItem;
import br.ufrn.ru_ufrn.model.ResultadoAvaliacoes;

public interface AvaliacaoController {
	

	public Avaliacao getavaliacao( String data, String refeicao, int idUser);
	
	//public AvaliacaoItem getAvItem(String data,  int idRefeicao, String item);
	
	public void avaliarCardapio(Avaliacao avaliacao);
	
	public void avaliarItem(AvaliacaoItem avItem);
	
	public void atualizaAvCardapio(Avaliacao avaliacao, int idUser, String refeicao,String data);
	
	public void atualizarAVItem(AvaliacaoItem avItem ,int idUser, String refeicao,String data, String item);
	
	public ResultadoAvaliacoes resultadoAvaliacoes(String refeicao, String data );
	
	public ResultadoAvItem[] getresultadoAvItem(String refeicao, String data );

}
