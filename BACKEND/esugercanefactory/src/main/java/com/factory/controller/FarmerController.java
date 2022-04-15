package com.factory.controller;

import java.security.Provider.Service;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.factory.entity.Contractor;
import com.factory.entity.Farmer;
import com.factory.entity.HarvestingData;
import com.factory.service.FarmerService;

@RestController
@CrossOrigin//(origins = "http://localhost:3000")
@RequestMapping(value ="/farmer")
public class FarmerController {

	@Autowired
	public FarmerService service;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Farmer farmer)
	{
		String str=service.register(farmer);
		return new ResponseEntity<>(str, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getallfarmer")
	public ResponseEntity<Object> getAll()
	{ 
		List<Farmer> list=service.getall();
		if( list.isEmpty())
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(list);

	}
	@PutMapping("/updatefarmer")
	public ResponseEntity<String> UpdateFarmer(@RequestBody Farmer farmer)
	{
		String str=service.UpdateFarmer(farmer);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}

	@DeleteMapping("/deleteFarmer/{fid}")
	public ResponseEntity<String> DeleteFarmer(@PathVariable Integer fid) {
		String str=service.DeleteFarmer(fid);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}

	@GetMapping("/getPerticularFarmer/{fid}")
	public ResponseEntity<Farmer> GetPerticularFarmer(@PathVariable Integer fid)
	{
		Farmer farmer=service.GetPerticularFarmer(fid);
		if(farmer==null)
			return new ResponseEntity<Farmer>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Farmer>(farmer,HttpStatus.OK);
	}
	@PostMapping("/bookContractor")
	public ResponseEntity<String> bookContractor(@RequestBody HarvestingData data)
	{
		String str=service.bookContractor(data);

		return new ResponseEntity<String>(str,HttpStatus.OK) ;
	}

}
