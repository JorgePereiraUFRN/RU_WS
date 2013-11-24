package br.ufrn.ru_ufrn.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultadoAvaliacoes {

	private int iDrefeicao;
	private int gostaram;
	private int desgostaram;
	private int indiferente;
	private int cardapioCumprido;
	private int cardapioDescumprido;
	private int totaVotos;
	private Date data;
	private String refeicao;
	
	
	
	public int getCardapioCumprido() {
		return cardapioCumprido;
	}

	public void setCardapioCumprido(int cardapioCumprido) {
		this.cardapioCumprido = cardapioCumprido;
	}

	public int getCardapioDescumprido() {
		return cardapioDescumprido;
	}

	public void setCardapioDescumprido(int cardapioDescumprido) {
		this.cardapioDescumprido = cardapioDescumprido;
	}

	public String getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(String refeicao) {
		this.refeicao = refeicao;
	}

	public ResultadoAvaliacoes(){
		
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public int getiDrefeicao() {
		return iDrefeicao;
	}

	public void setiDrefeicao(int iDrefeicao) {
		this.iDrefeicao = iDrefeicao;
	}

	public int getGostaram() {
		return gostaram;
	}

	public void setGostaram(int gostaram) {
		this.gostaram = gostaram;
	}

	public int getDesgostaram() {
		return desgostaram;
	}

	public void setDesgostaram(int desgostaram) {
		this.desgostaram = desgostaram;
	}

	public int getIndiferente() {
		return indiferente;
	}

	public void setIndiferente(int indiferente) {
		this.indiferente = indiferente;
	}

	public int getTotaVotos() {
		return totaVotos;
	}

	public void setTotaVotos(int totaVotos) {
		this.totaVotos = totaVotos;
	}

}
