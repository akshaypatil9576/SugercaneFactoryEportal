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

import com.factory.entity.Contractor;
import com.factory.entity.HarvestingData;
import com.factory.service.ContractorService;

@RestController
@CrossOrigin//(origins = "http://localhost:3000")
@RequestMapping(value ="/contractor")
public class ContractorController {

	@Autowired
	public  ContractorService service;
	
	@PostMapping("/register")
	public  ResponseEntity<String> registerUser(@RequestBody Contractor contractor)
	{
		String str =service.register(contractor);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getallContractor")
	public ResponseEntity< List<Contractor>>  getall()
	{
		List<Contractor> list=service.getall();
		return ResponseEntity.ok(list) ;
	}
	@PutMapping("/updateContractor")
	public ResponseEntity<String> UpdateContractor(@RequestBody Contractor contractor)
	{
		String str=service.UpdateContractor(contractor);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteContractor/{cid}")
	public ResponseEntity<String> DeleteContractor(@PathVariable int cid) {
		
		

		String str=service.DeleteContractor(cid);
		return new ResponseEntity<>(str,HttpStatus.OK);
		
	}
	
	//to get particular record
	@GetMapping("/getParticularContractor/{cid}")
	public ResponseEntity<Contractor> GetPerticularContractor(@PathVariable Integer cid)
	{
		Contractor contractor=service.GetPerticularContractor(cid);
		if(contractor==null)
		return new ResponseEntity<Contractor>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Contractor>(contractor,HttpStatus.OK);
	}
	
	//to get information about harvesting scheduling 
	@GetMapping("/harvestingScheduling")
	public ResponseEntity<List<HarvestingData>> getHarvestingSchedule()
	{
		List<HarvestingData> list=service.getHarvestingSchedule();
		System.out.println(list);
		return new  ResponseEntity<List<HarvestingData>>(list,HttpStatus.OK);
	}
	
	
	
	
}
