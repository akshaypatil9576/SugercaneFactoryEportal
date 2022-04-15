package com.factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factory.entity.Admin;
import com.factory.entity.Login;
import com.factory.service.AdminService;
import com.factory.service.ContractorService;
import com.factory.service.FarmerService;

@RestController
@CrossOrigin//(origins = "http://localhost:3000")
@RequestMapping(value="v1/api/login")
public class LoginController {
	
	
	@Autowired
	AdminService adminService;
	@Autowired
	FarmerService farmerService;
	@Autowired
	ContractorService contractorService;
	
//	public ResponseEntity<String> registerAdmin(@RequestBody Login login )
//	{
//		String str=adminService.loginService(login);
//		return new ResponseEntity<>(str,HttpStatus.OK);
//	}

	
	@PostMapping("/adminlogin")
	public ResponseEntity<String> loginAdmin(@RequestBody Login login)
	{
		String  res= adminService.loginService(login);
	
		return new ResponseEntity<String >(res,HttpStatus.OK);
		
		
	}
	
	@PostMapping("/farmerlogin")
	public ResponseEntity<String> loginFarmer(@RequestBody Login login)
	{
		String str =farmerService.loginService(login);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
	
	
	@PostMapping("/contractorlogin")
	public ResponseEntity<String> loginContractor(@RequestBody Login login)
	{
		String str =contractorService.loginService(login);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}

}
