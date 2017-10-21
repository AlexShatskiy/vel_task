package com.shatskiy.vel.domain;

import java.util.List;

public class Tender {
	
	private Integer id;
	private List<String> email;
	private List<String> phone;
	private String finishTender;
	
	public Tender() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}

	public String getFinishTender() {
		return finishTender;
	}

	public void setFinishTender(String finishTender) {
		this.finishTender = finishTender;
	}


	
	
	
	


	
	
	
	
}
