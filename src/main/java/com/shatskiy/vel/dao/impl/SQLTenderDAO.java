package com.shatskiy.vel.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.shatskiy.vel.dao.TenderDAO;
import com.shatskiy.vel.domain.Email;
import com.shatskiy.vel.domain.Phone;
import com.shatskiy.vel.domain.Tender;

@Repository("sqlTenderDAO")
public class SQLTenderDAO implements TenderDAO {
	
	private static final Logger log = Logger.getLogger(CsvTenderDAO.class);

	@Override
	public void addTender(Tender tender) {

		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(tender);
		 
		for(Email email: tender.getEmail()){
			email.setTender(tender);
			session.saveOrUpdate(email);
		}
		
		for(Phone phone: tender.getPhone()){
			phone.setTender(tender);
			session.saveOrUpdate(phone);
		}
		
		session.getTransaction().commit();
		session.close();
		log.error("sqlTenderDAO");
	}
}
