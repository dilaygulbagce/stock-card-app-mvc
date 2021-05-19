package com.dilaygulbagce.stockCardApplication.utility;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;

import tr.com.guru.common.utility.BaseEntityRepository;
import tr.com.guru.common.utility.EntityRepository;

@EntityRepository
public class StokAppEntityRepository extends BaseEntityRepository {

	@Override
	public void setEntities() {
		addEntity(WarehouseCardModel.class);
	}

}
