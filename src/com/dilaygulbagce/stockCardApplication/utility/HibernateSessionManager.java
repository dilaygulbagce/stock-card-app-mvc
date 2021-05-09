package com.dilaygulbagce.stockCardApplication.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionManager {
	
	SessionFactory sessionFactory = new Configuration()
									.configure("hibernate.cfg.xml")
									.buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();
	
	public Session getSession() {
		return session;
	}

}
