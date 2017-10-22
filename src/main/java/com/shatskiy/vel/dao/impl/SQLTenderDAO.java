package com.shatskiy.vel.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.shatskiy.vel.dao.TenderDAO;
import com.shatskiy.vel.domain.Tender;

@Repository("sqlTenderDAO")
public class SQLTenderDAO implements TenderDAO {

	@Override
	public void addTender(Tender tender) {
		/*
		Tender2 tender2 = new Tender2();
		tender2.setId(1);
		String[] mass = {"dsfs", "dfsdf"};
		tender2.setEmail(mass);
		tender2.setPhone(mass);
		tender2.setFinish("asd");
		*/
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		session.save(tender);
 
		session.getTransaction().commit();
		session.close();
	}
}
