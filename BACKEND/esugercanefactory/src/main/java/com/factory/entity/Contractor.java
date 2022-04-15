package com.factory.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.factory.utility.CurrentTime;
@Component
@Table(name = "contractor_data")
@Entity
public class Contractor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String password;
	private String cname;
	private String ccontact;
	private String caddress;
	private String vehicalInfo;
	private final String type="contractor";
	private int manpower;
	private String created_on;
	private String updated_on;
	private String c_status;
	
	
	public Contractor() {
		
		
		
	}
	
	public Contractor(int cid, String password, String cname, String ccontact, String caddress, String vehicalInfo,
			String type, int manpower, String created_on, String updated_on, String c_status) {
		super();
		this.cid = cid;
		this.password = password;
		this.cname = cname;
		this.ccontact = ccontact;
		this.caddress = caddress;
		this.vehicalInfo = vehicalInfo;
		this.manpower = manpower;
		this.created_on = created_on;
		this.updated_on = updated_on;
		this.c_status = c_status;
	}





	public int getManpower() {
		return manpower;
	}


	public void setManpower(int manpower) {
		this.manpower = manpower;
	}


	public String getCreated_on() {
		return created_on;
	}


	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}


	public String getUpdated_on() {
		return updated_on;
	}


	public void setUpdated_on(String updated_on) {
		this.updated_on = updated_on;
	}


	public String getC_status() {
		return c_status;
	}


	public void setC_status(String c_status) {
		this.c_status = c_status;
	}

	public String getType() {
		return type;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	} 
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcontact() {
		return ccontact;
	}
	public void setCcontact(String ccontact) {
		this.ccontact = ccontact;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getVehicalInfo() {
		return vehicalInfo;
	}
	public void setVehicalInfo(String vehicalInfo) {
		this.vehicalInfo = vehicalInfo;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
