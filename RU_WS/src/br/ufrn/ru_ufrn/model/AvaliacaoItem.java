package br.ufrn.ru_ufrn.model;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AvaliacaoItem {
	
	private String item;
	private Long idUsuario;
	private Date data;
	private NivelSatisfacao nivelSatisfacao;
	private Long idAvaliacao;
	private String refeicao;
	
	public static final String ALMOCO_CARNIVORO = "almoço carnívoro",
			ALMOCO_VEGETARIANO = "almoço vegetarioano", CAFE = "café da manhã",
			JANTAR_CARNIVORO = "jantar carnivoro",
			JANTAR_VEGETARIANO = "jantar vegetariano";

	public AvaliacaoItem() {
		// TODO Auto-generated constructor stub
	}
	

	public String getRefeicao() {
		return refeicao;
	}


	public void setRefeicao(String refeicao) {
		this.refeicao = refeicao;
	}


	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public NivelSatisfacao getNivelSatisfacao() {
		return nivelSatisfacao;
	}

	public void setNivelSatisfacao(NivelSatisfacao nivelSatisfacao) {
		this.nivelSatisfacao = nivelSatisfacao;
	}

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	
	public void setNivelSatisfacao(String nivelSatisfacao) {
		NivelSatisfacao ns = null;
		if(nivelSatisfacao.equals(ns.GOSTEI.toString())){
			ns = ns.GOSTEI;
		}else if(nivelSatisfacao.equals(ns.DESGOSTEI.toString())){
			ns = ns.DESGOSTEI;
		}else{
			ns = ns.INDIFERENTE;
		}
		
		this.nivelSatisfacao = ns;
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
