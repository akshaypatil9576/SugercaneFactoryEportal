package com.factory.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "harvesting_scheduling")
public class HarvestingData implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hid;
	private String hdate;
	private String schedule_dt;
	private int fid;
	private int cid;
	private String status;
	
	public HarvestingData()
	{
		
	}



	public HarvestingData(int hid, String hdate, String schedule_dt, int fid, int cid, String status) {
		super();
		this.hid = hid;
		this.hdate = hdate;
		this.schedule_dt = schedule_dt;
		this.fid = fid;
		this.cid = cid;
		this.status = status;
	}


	
	public String getSchedule_dt() {
		return schedule_dt;
	}

	public void setSchedule_dt(String schedule_dt) {
		this.schedule_dt = schedule_dt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}



	@Override
	public String toString() {
		return "HarvestingData [hid=" + hid + ", hdate=" + hdate + ", schedule_dt=" + schedule_dt + ", fid=" + fid
				+ ", cid=" + cid + ", status=" + status + "]";
	}
	
	
	
	
}
