package br.ufrn.ru_ufrn.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Model {
	
	protected Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
