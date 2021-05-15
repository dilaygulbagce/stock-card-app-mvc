package com.dilaygulbagce.stockCardApplication.model;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dilaygulbagce.stockCardApplication.utility.HibernateSessionManager;

public abstract class BaseCardModel {
			
	HibernateSessionManager sessionManager = new HibernateSessionManager();

	@Transient
	HashMap<String, String> stockTypeMap = new HashMap<String, String>() {{
		put("1", "Süt ve Süt Ürünleri");
		put("2", "Et ve Et Ürünleri");
		put("3", "Yağ");
		put("4", "Meyve ve Sebze Ürünleri");
		put("5", "Konserve Gıda");
		put("6", "Dondurulmuş Gıda");
		put("7", "Kuru Gıda");
		put("8", "Unlu Mamüller");
		put("9", "Su Ürünleri");
	}};
	
	public <E> List<E> list(String whereClause) {
		HibernateSessionManager sessionManager = new HibernateSessionManager();

		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();

		@SuppressWarnings("unchecked")
		Query<E> query = session.createQuery("from " + getClass().getName() + " " + whereClause);
		List<E> results = query.getResultList();

		transaction.commit();
		session.close();
		return results;
	}
	
	public boolean insert() {

		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		session.save(this);
		transaction.commit();
		session.close();
		
		return true;
	}
	
	public boolean delete() {

		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();

		session.delete(this);
		transaction.commit();
		session.close();
		
		return true;
	}

	public boolean update() {

		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();

		session.update(this);
		transaction.commit();
		session.close();
		
		return true;
	}
	
	public <E> Object search(String code) {	

		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();

		Object find = session.get(getClass().getName(), code);
		
		transaction.commit();
		session.close();
		
		return find;
	}
	
	public boolean isRecorded(String code) {

		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();

		Object find = session.get(getClass().getName(), code);
		
		if(find == null) {
			return false;
		}
		
		transaction.commit();
		session.close();
		
		return true;
	}
}
