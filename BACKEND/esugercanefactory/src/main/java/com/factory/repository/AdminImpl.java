package com.factory.repository;

import java.util.List;

import org.aspectj.weaver.tools.Trace;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.factory.config.ConfigClass;
import com.factory.entity.Admin;
import com.factory.entity.HarvestingData;



	@Repository
	public class AdminImpl {
		
		@Autowired
		public ConfigClass config;
		
		@Autowired
		SessionFactory factory;
		
		public String register(Admin admin) {
			Session session= factory.openSession();
			Transaction transaction =session.beginTransaction();
			session.save(admin);
			transaction.commit();
			return admin.getAname();
		}

		public List<Admin> getall() {
			// TODO Auto-generated method stub
			Session session=factory.openSession();
			List<Admin> list=session.createCriteria(Admin.class).list();
			return list;
		}

		public String DeleteAdmin(Integer aid) {
			// TODO Auto-generated method stub
			Session session=factory.openSession();
			Transaction transaction=session.beginTransaction();
			Criteria criteria=session.createCriteria(Admin.class);
			criteria.add(Restrictions.eqOrIsNull("aid", aid));
			Admin admin=(Admin) criteria.uniqueResult();
			session.delete(admin);
			transaction.commit();
			
			return "Admin "+aid+"id is deleted succesfully..!";
		}

		public String UpdateAdmin(Admin admin) {
			// TODO Auto-generated method stub
			Session session=factory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(admin);
			transaction.commit();
			return "Admin"+admin.getAid()+"Updated Succesfully....!";
		}

//		public String deleteHarvestingScheduling() {
//			// TODO Auto-generated method stub
//			Session session=factory.openSession();
//			Transaction transaction=session.beginTransaction();
//			Criteria criteria=session.createCriteria(HarvestingData.class);
//			criteria.add(Restrictions.eqOrIsNull("hid", hid));
//			HarvestingData data=(HarvestingData) criteria.uniqueResult();
//			session.delete(data);
//			transaction.commit();
//			
//			return "Harvesing Scheduling of"+hid+"harvesting id is deleted succesfully..!";
//		}
	}

