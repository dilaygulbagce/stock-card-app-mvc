package com.dilaygulbagce.stockCardApplication.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dilaygulbagce.stockCardApplication.utility.HibernateSessionManager;

import tr.com.guru.common.model.BaseEntity;
import tr.com.guru.common.model.MasterValue;
import tr.com.guru.common.view.MainFrameInterface;

@Entity
@Table(name = WarehouseCardModel.TABLE)
public class WarehouseCardModel extends BaseEntity implements Serializable {
	
	public static final String TABLE = "warehouse_card";
	public static final String ALIAS = "w";
	
	public static final int CODE_LIMIT = 15;
	public static final int NAME_LIMIT = 50;
	public static final int DESCRIPTION_LIMIT = 100;
	
	@MasterValue
	public static final String KODU = "warehouseCode";
	
	@Column(name = "code", nullable=false, length=CODE_LIMIT)
	private String warehouseCode;
	
	@Column(name = "name", nullable=false, length=NAME_LIMIT)
	private String warehouseName;
	
	@Column(name = "description", nullable = true, length=DESCRIPTION_LIMIT)
	private String warehouseDescription;
	
	public WarehouseCardModel() {
		super(null);
	}
	
	public WarehouseCardModel(MainFrameInterface mainFrame) {
		super(mainFrame);
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

	public <E> List<E> fillWarehouseCodeCombobox(String whereClause) {
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

	@Override
	public BaseEntity emptyModel() {
		return new WarehouseCardModel(mainFrame);
	}
	
	@Override
	public void setCodeChangeComponentDataList() {
		
	}
	
	@Override
	public String getTableName() {
		return TABLE;
	}
	
	@Override
	public String getAlias() {
		return ALIAS;
	}
}
