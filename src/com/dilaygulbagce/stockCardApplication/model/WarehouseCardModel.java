package com.dilaygulbagce.stockCardApplication.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dilaygulbagce.stockCardApplication.utility.HibernateSessionManager;

@Entity
@Table(name = "warehouse_card")
public class WarehouseCardModel<E> {
	
	public static final int CODE_LIMIT = 15;
	public static final int NAME_LIMIT = 50;
	public static final int DESCRIPTION_LIMIT = 100;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String warehouseID;
	
	@Column(name = "code")
	private String warehouseCode;
	
	@Column(name = "name")
	private String warehouseName;
	
	@Column(name = "description")
	private String warehouseDescription;
	
	public WarehouseCardModel() {
		
	}
	
	public WarehouseCardModel(String warehouseID, String warehouseCode, String warehouseName,
			String warehouseDescription) {
		this.warehouseID = warehouseID;
		this.warehouseCode = warehouseCode;
		this.warehouseName = warehouseName;
		this.warehouseDescription = warehouseDescription;
	}

	public String getWarehouseID() {
		return warehouseID;
	}
	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWarehouseDescription() {
		return warehouseDescription;
	}
	public void setWarehouseDescription(String warehouseDescription) {
		this.warehouseDescription = warehouseDescription;
	}

	public List<E> list(String whereClause) {
		HibernateSessionManager sessionManager = new HibernateSessionManager();
		
		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		@SuppressWarnings("unchecked")
		Query<E> query = session.createQuery("from WarehouseCardModel");
		List<E> results = query.getResultList();

		session.close();
		return results;
	}
	
	public boolean insert() {
		HibernateSessionManager sessionManager = new HibernateSessionManager();
		
		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		session.save(this);
		transaction.commit();
		session.close();
		
		return true;
	}
	
	public boolean delete() {
		HibernateSessionManager sessionManager = new HibernateSessionManager();
		
		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		session.delete(this);
		transaction.commit();
		session.close();
		
		return true;
	}
	
	public boolean update() {
		HibernateSessionManager sessionManager = new HibernateSessionManager();
		
		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		session.update(this);
		transaction.commit();
		session.close();
		
		return true;
	}

	public boolean search() {
		HibernateSessionManager sessionManager = new HibernateSessionManager();
		
		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
			
		transaction.begin();
		Query query = session.createQuery("from WarehouseCardModel where code = :code");
		query.setParameter("code", getWarehouseCode());
		
		WarehouseCardModel find = (WarehouseCardModel) query.list().get(0);
		setWarehouseCode(find.warehouseCode);
		setWarehouseName(find.warehouseName);
		setWarehouseDescription(find.warehouseDescription);
		
		transaction.commit();
		session.close();
		
		return true;
	}
	
	public boolean isRecorded() {
		HibernateSessionManager sessionManager = new HibernateSessionManager();
		
		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		Query query = session.createQuery("from WarehouseCardModel where code = :code");
		query.setParameter("code", getWarehouseCode());
		
		int find = query.list().size();
		
		if(find == 0) {
			return false;
		}
		return true;
	}
	
	public List<E> fillWarehouseCodeCombobox(String whereClause) {
		HibernateSessionManager sessionManager = new HibernateSessionManager();
		
		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		List<E> results = new ArrayList<>();
		results.add(null);
		
		@SuppressWarnings("unchecked")
		Query<E> query = session.createQuery("select w.warehouseCode from WarehouseCardModel w");
		results.addAll(query.getResultList());
		session.close();
		return results;
		
	}
}
