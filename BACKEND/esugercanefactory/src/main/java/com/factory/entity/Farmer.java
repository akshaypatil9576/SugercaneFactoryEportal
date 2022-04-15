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
@Table(name = "farmer_data")
public class Farmer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fid;
	private String password;
	private String fname;
	private String fcontact;
	private String faddress;
	private int area;
	private int share;
	private String created_on;
	private String updated_on;
	private final String type="farmer";

	public Farmer() {


	}
	public Farmer(int fid, String password, String fname, String fcontact, String faddress, int area, int share,
			String created_on, String updated_on, String type) {
		super();
		this.fid = fid;
		this.password = password;
		this.fname = fname;
		this.fcontact = fcontact;
		this.faddress = faddress;
		this.area = area;
		this.share = share;
		this.created_on = created_on;
		this.updated_on = updated_on;
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


	public String getType() {
		return type;
	}

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFcontact() {
		return fcontact;
	}
	public void setFcontact(String fcontact) {
		this.fcontact = fcontact;
	}
	public String getFaddress() {
		return faddress;
	}
	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}


}
