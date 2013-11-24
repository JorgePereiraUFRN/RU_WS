package br.ufrn.ru_ufrn.model;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Avaliacao {

	private Integer id;
	private Boolean cardapioCumprido;
	private Date data;
	private Integer idAvaliacao;
	private Integer idRefeicao;
	private Long idUsuario;
	private String refeicao;
	
	public Avaliacao(){
		this.id = -1;
		this.idRefeicao = -1;
		this.idUsuario = -1L;
	}


	public static final String ALMOCO_CARNIVORO = "almoço carnívoro",
			ALMOCO_VEGETARIANO = "almoço vegetarioano", CAFE = "café da manhã",
			JANTAR_CARNIVORO = "jantar carnivoro",
			JANTAR_VEGETARIANO = "jantar vegetariano";

	
	

	public String getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(String refeicao) {
		this.refeicao = refeicao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean isCardapioCumprido() {
		return cardapioCumprido;
	}

	public void setCardapioCumprido(boolean cardapioCumprido) {
		this.cardapioCumprido = cardapioCumprido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	


	/*
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
*/

	public Boolean getCardapioCumprido() {
		return cardapioCumprido;
	}

	public void setCardapioCumprido(Boolean cardapioCumprido) {
		this.cardapioCumprido = cardapioCumprido;
	}

	public Integer getIdRefeicao() {
		return idRefeicao;
	}

	public void setIdRefeicao(Integer idRefeicao) {
		this.idRefeicao = idRefeicao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
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

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	
	

}
