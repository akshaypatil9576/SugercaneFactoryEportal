package com.factory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.factory.entity.Admin;
import com.factory.entity.Farmer;
import com.factory.entity.Login;
//import com.factory.repo.AdminRepo;
import com.factory.repository.AdminImpl;
import com.factory.utility.CurrentTime;



@Service
public class AdminService {

	@Autowired
	public AdminImpl impl;

	@Autowired
	//private AdminRepo adminRepo;

	public String register(Admin admin) {
		//logic
		admin.setCreated_on(CurrentTime.getCurrentDateTimeMS());
		admin.setCreated_on(CurrentTime.getCurrentDateTimeMS());
		return impl.register(admin);
	}

	public List<Admin>  getallAdmin() {

		List<Admin> list=impl.getall();
		return list;
	}

	public String loginService(Login login) {
		List<Admin> list=impl.getall();
		for (Admin admin:list )
		{
			if((admin.getAname().equals(login.getUsername())&& admin.getPassword().equals(login.getPassword())))
			{
				System.out.println(" Login Success");
				System.out.println(admin+" in Service");
				return "true";
			}
		}
		return "false";

	}


	//	public Admin loginService(Login login) {
	//		List<Admin> list=impl.getall();
	//		Admin admin2=new Admin();
	//		for(Admin admin:list)
	//		{
	//			System.out.println(admin);
	//			if((admin.getAname().equals(login.getUsername()) && admin.getPassword().equals(login.getPassword())))
	//			admin2=admin;
	//				
	//			
	//			
	//		}return admin2;
	//	}

	//	public ResponseEntity<Admin> loginAdmin(Admin admin)
	//	{
	//		 admin= adminRepo.findByAname(admin.getAname());
	//		
	//		if(admin.getAname().equals(admin.getAname()) && admin.getPassword().equals(admin.getPassword()))
	//		{
	//			return new ResponseEntity<Admin>(admin,HttpStatus.ACCEPTED);
	//		}
	//		
	//		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	//	}
	//	






	public String DeleteAdmin(Integer aid) {

		String str=impl.DeleteAdmin(aid);
		return str;
	}

	public String UpdateAdmin(Admin admin) {
		// TODO Auto-generated method stub

		admin.setCreated_on(CurrentTime.getCurrentDateTimeMS());
		String str =impl.UpdateAdmin(admin);
		return str;
	}

//	public String deleteHarvestingScheduling(Integer hid) {
//	
//		String str=impl.deleteHarvestingScheduling();
//		
//		return str;
//	}


}



