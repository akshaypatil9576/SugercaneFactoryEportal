package com.factory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factory.entity.Admin;
import com.factory.entity.Farmer;
import com.factory.service.AdminService;

@RestController
@CrossOrigin//(origins = "http://localhost:3000")
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	public AdminService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Admin admin)
	{
		String str=service.register(admin);
		return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getallAdmin")
	public ResponseEntity<Object> getallAdmin() {
		List<Admin> list=service.getallAdmin();
		if(list.isEmpty())
		
		return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/deleteAdmin/{aid}")
	public ResponseEntity<String> DeleteAdmin(@PathVariable Integer aid) {
		String str=service.DeleteAdmin(aid);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<String> UpdateAdmin(@RequestBody Admin admin)
	{
		String str=service.UpdateAdmin(admin);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
//	@DeleteMapping("/deleteHarvesingScheduling/{hid}")
//	public ResponseEntity<String> deleteHarvestingScheduling(@PathVariable Integer hid){
//		String str=service.deleteHarvestingScheduling(hid);
//		return new ResponseEntity<>(str,HttpStatus.OK);
//	}
	
	
	
}
