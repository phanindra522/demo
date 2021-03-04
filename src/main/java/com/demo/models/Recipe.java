package com.demo.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Recipe implements Serializable {

	private String q;
	private String healt;
	//https://api.edamam.com/search?app_id=900da95e&app_key=40698503668e0bb3897581f4766d77f9&q=coffee
	//https://api.edamam.com/search?app_id=900da95e&app_key=40698503668e0bb3897581f4766d77f9&q=coffee&healt=alcohol-free
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public String getHealt() {
		return healt;
	}
	public void setHealt(String healt) {
		this.healt = healt;
	}
	
}
