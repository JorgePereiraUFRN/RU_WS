package br.ufrn.ru_ufrn.model;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultadoAvItem {
	
	private String item;
	private Integer gostaram;
	private Integer desgostaram;
	private Integer indiferente;
	private Integer totalVotos;
	private Date data;
	private String refeicao;
	

	public ResultadoAvItem() {
		// TODO Auto-generated constructor stub
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public Integer getGostaram() {
		return gostaram;
	}


	public void setGostaram(Integer gostaram) {
		this.gostaram = gostaram;
	}


	public Integer getDesgostaram() {
		return desgostaram;
	}


	public void setDesgostaram(Integer desgostaram) {
		this.desgostaram = desgostaram;
	}


	public Integer getIndiferente() {
		return indiferente;
	}


	public void setIndiferente(Integer indiferente) {
		this.indiferente = indiferente;
	}


	public Integer getTotalVotos() {
		return totalVotos;
	}


	public void setTotalVotos(Integer totalVotos) {
		this.totalVotos = totalVotos;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getRefeicao() {
		return refeicao;
	}


	public void setRefeicao(String refeicao) {
		this.refeicao = refeicao;
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
