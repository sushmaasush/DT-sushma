package com.niit.ColorsBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Products")
@Component

public class Product {
	
	@Id
	private String pid;
	private String pname;
	private String pcat;
	public String getPcat() {
		return pcat;
	}
	public void setPcat(String pcat) {
		this.pcat = pcat;
	}
	private String pprice;
	private String pstock;
	public String getPstock() {
		return pstock;
	}
	public void setPstock(String pstock) {
		this.pstock = pstock;
	}
	private String pdes;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdes() {
		return pdes;
	}
	public void setPdes(String pdes) {
		this.pdes = pdes;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

}
