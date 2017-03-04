package com.stealth.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class GSubModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5105486105389975358L;
	private int subId;
	private String subName;
	public GSubModel(){
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
}
