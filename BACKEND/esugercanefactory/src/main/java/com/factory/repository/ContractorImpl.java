package com.factory.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.factory.config.ConfigClass;
import com.factory.entity.Contractor;
import com.factory.entity.HarvestingData;

@Repository
public class ContractorImpl {
	
	@Autowired
	public ConfigClass config;
	
	@Autowired
	SessionFactory factory;
	
	
	
	public String register(Contractor contractor) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		session.save(contractor);
		transaction.commit();
		return contractor.getCname();
	}



	public List<Contractor> getall() {
		// TODO Auto-generated method stub
		
		Session session=factory.openSession();
		List<Contractor> list=session.createCriteria(Contractor.class).list();
		return list;
	}



	public String UpdateContractor(Contractor contractor) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		/*
		 * Criteria criteria=session.createCriteria(Contractor.class);
		 * 
		 * criteria.add(Restrictions.eq("cid",contractor.getCid() ));
		 */
		session.saveOrUpdate(contractor);
		transaction.commit();
		return "Contractor "+contractor.getCid()+"Updates Succesfully....";
	}



	public String deleteContractor(int cid) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Criteria criteria=session.createCriteria(Contractor.class);
		criteria.add(Restrictions.eq("cid", cid));
	    Contractor contractor=(Contractor) criteria.uniqueResult();
		
		session.delete(contractor);
		transaction.commit();
		
		
		return "Contractor of cid "+cid+"  is Deleted succesfully....";
	}



	public Contractor GetPerticularContractor(Integer cid) {
		// TODO Auto-generated method stub
		
		Session session=factory.openSession();
		 Criteria criteria=session.createCriteria(Contractor.class);//we are using criteria becoze we want perticular record so we are not creating transaction here
		 criteria.add(Restrictions.eq("cid", cid));
		 Contractor contractor=(Contractor)criteria.uniqueResult();
		return contractor;
	}



	public List<HarvestingData> getHarvestingSchedule() {

		Session session=factory.openSession();
		List<HarvestingData> list=session.createCriteria(HarvestingData.class).list();
		return list;
	}

}
