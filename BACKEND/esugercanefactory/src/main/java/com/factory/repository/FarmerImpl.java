 package com.factory.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.factory.entity.Contractor;
import com.factory.entity.Farmer;
import com.factory.entity.HarvestingData;

@Transactional
@Repository
public class FarmerImpl {

	@Autowired
	SessionFactory factory;
	
	@Autowired
	ContractorImpl contractorImpl;
	
	public String register(Farmer farmer) {
		Session session= factory.openSession();
		System.out.println("In Farmer impl");
		Transaction transaction= session.beginTransaction();
		session.save(farmer);
		transaction.commit();
		return farmer.getFname();
	}

	public List<Farmer> getall() {

		Session session=factory.openSession();
		  List<Farmer> list= session.createCriteria(Farmer.class).list();
		
		return list ;
	}

	public String UpdateFarmer(Farmer farmer) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction  transaction=session.beginTransaction();
		session.saveOrUpdate(farmer);
		transaction.commit();
		return "Farmer"+farmer.getFid()+"Updates Succesfully...";
	}

	public String DeleteFarmer(Integer fid) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Farmer.class);
		criteria.add(Restrictions.eq("fid", fid));
		Farmer farmer=(Farmer) criteria.uniqueResult();
		session.delete(farmer);
		transaction.commit();
		return "Farmer"+fid+"id deleted sucssesfully...!!" ;
	}

	public Farmer GetPerticularFarmer(Integer fid) {
		// TODO Auto-generated method stub
	
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Farmer.class);
		criteria.add(Restrictions.eq("fid", fid));
		Farmer farmer=(Farmer)criteria.uniqueResult();
		return farmer;
	}

	

	public String bookContractor(HarvestingData data) {

		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(data);
		Farmer farmer=GetPerticularFarmer(data.getFid());
		Contractor contractor =contractorImpl.GetPerticularContractor(data.getCid());
		transaction.commit();
		return "Contractor "+contractor.getCname()+" is booked by Farmer "+farmer.getFname();
	}

}
