package br.ufrn.ru_ufrn.model;

import java.util.Calendar;
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
	
	public String getDataFormatoAmericano() {
		return (data.getYear()+1900)+"-"+(data.getMonth()+1)+"-"+data.getDate();
	}
	
	public void setData(String dataFormatoamericano){
		
		String d[] = dataFormatoamericano.split("-");
		int ano = Integer.parseInt(d[0]);
		int mes = Integer.parseInt(d[1]) - 1;
		int dia = Integer.parseInt(d[2]);
		
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(ano, mes , dia);
		
		this.data = calendar.getTime();
		
	}

	
	


}
