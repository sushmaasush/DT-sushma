package com.niit.ColorsBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class UserDetails {
	
	@Id
	private String id;
	private String name;
	private String mailId;
	private String contact_No;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getContact_No() {
		return contact_No;
	}
	public void setContact_No(String contact_No) {
		this.contact_No = contact_No;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
