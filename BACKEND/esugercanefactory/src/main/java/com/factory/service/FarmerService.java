package com.factory.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.entity.Farmer;
import com.factory.entity.HarvestingData;
import com.factory.entity.Login;
import com.factory.repository.FarmerImpl;
import com.factory.utility.CurrentTime;
@Transactional
@Service
public class FarmerService {



	@Autowired
	public FarmerImpl impl;


	public  String register(Farmer farmer) {
		//business logic

		farmer.setCreated_on(CurrentTime.getCurrentDateTimeMS());
		farmer.setUpdated_on(CurrentTime.getCurrentDateTimeMS());
		farmer.setFid(0);
		return impl.register(farmer);
	}

	public List<Farmer>  getall() {

		List<Farmer> list=impl.getall();
		return list; 
	}

	public String UpdateFarmer(Farmer farmer) {

		farmer.setUpdated_on(CurrentTime.getCurrentDateTimeMS());
		String str= impl.UpdateFarmer(farmer);
		return str;
	}

	public String loginService(Login login) {

		List<Farmer> list =impl.getall();

		for(Farmer farmer:list)
		{
			if(farmer.getFname().equals(login.getUsername())&& farmer.getPassword().equals(login.getPassword()))
			{
				System.out.println("login Succesfull");
				return "true";
			}

		}
		return "false";
	}

	public String DeleteFarmer(Integer fid) {
		// TODO Auto-generated method stub
		String str=impl.DeleteFarmer(fid);
		return str;
	}

	public Farmer GetPerticularFarmer(int fid) {
		// TODO Auto-generated method stub
		Farmer op = impl.GetPerticularFarmer(fid);
		if(op!= null) {

			return op;
		}

		return null;
	}

	public String bookContractor(HarvestingData data) {

		
		data.setHdate(CurrentTime.getCurrentDateTimeMS());
		
		String str =impl.bookContractor(data);
		return str;
	}

	
	
}
