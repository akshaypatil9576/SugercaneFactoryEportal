package com.factory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.entity.Contractor;
import com.factory.entity.Farmer;
import com.factory.entity.HarvestingData;
import com.factory.entity.Login;
import com.factory.repository.ContractorImpl;
import com.factory.utility.CurrentTime;

@Service
public class ContractorService {

	@Autowired
	public ContractorImpl impl;

	public String register(Contractor contractor) {
		// logic
		contractor.setCreated_on(CurrentTime.getCurrentDateTimeMS());
		contractor.setUpdated_on(CurrentTime.getCurrentDateTimeMS());
		//contractor.setCid(0);
		return impl.register(contractor);
	}

	public String getallContractor() {

		return "Hello";
	}

	public List<Contractor> getall() {
		// TODO Auto-generated method stub

		List<Contractor> list=impl.getall();
		return list;
	}

	public String UpdateContractor(Contractor contractor) {
		// TODO Auto-generated method stub

		String str=impl.UpdateContractor(contractor);
		return str;
	}

	public String DeleteContractor(int cid) {
		// TODO Auto-generated method stub
		String str=impl.deleteContractor(cid);
		return str;
	}

	public Contractor GetPerticularContractor(Integer cid)
	{
		Contractor contractor=impl.GetPerticularContractor(cid);
		return contractor;
	}
	public String loginService(Login login) {
		
		List<Contractor> list =impl.getall();

		for(Contractor contractor:list)
		{
			if(contractor.getCname().equals(login.getUsername())&& contractor.getPassword().equals(login.getPassword()))
			{
				System.out.println("Contractor login succesfull");
				return "true";
			}
			 
		}
		return "false";
	}

	public List<HarvestingData> getHarvestingSchedule() {

		List<HarvestingData> list=impl.getHarvestingSchedule();
		return list;
	}

}
