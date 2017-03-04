package com.stealth.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4255785070719857296L;
	private int id;
	private String name;
	@Autowired
	private GSubModel gSubModel;
	
	public GModel() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GSubModel getgSubModel() {
		return gSubModel;
	}
	public void setgSubModel(GSubModel gSubModel) {
		this.gSubModel = gSubModel;
	}

}
