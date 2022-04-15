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
@Entity
@Table(name = "admin_data")
public class Admin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String password;
	private String aname;
	private String acontact;
	private String aaddress;
	private String created_on;
	private final String type= "admin";
	private String status;
	
	
	public Admin()  {
		
		
	}

	public Admin(int aid, String password, String aname, String acontact, String aaddress, String created_on,
			String type, String status) {
		super();
		this.aid = aid;
		this.password = password;
		this.aname = aname;
		this.acontact = acontact;
		this.aaddress = aaddress;
		this.created_on = created_on;
		this.status = status;
	}





	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid =aid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAcontact() {
		return acontact;
	}
	public void setAcontact(String acontact) {
		this.acontact = acontact;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public String getType() {
		return type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", password=" + password + ", aname=" + aname + ", acontact=" + acontact
				+ ", aaddress=" + aaddress + ", created_on=" + created_on + ", type=" + type + ", status=" + status
				+ "]";
	}
	
	
	

}
