package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class LoaiTienTe1RepositoryImpl implements LoaiTienTe1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private LoaiTienTe1Repository mLoaiTienTe1Repository;

	@Override
	public LoaiTienTe1 getLoaiTienTe1(long primaryKey) {

		return mLoaiTienTe1Repository.findOne(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiTienTe1> getAllLoaiTienTe1s() {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBSLOAITIENTE1_0_.* ");
		queryBuilder.append("FROM SBV.TBSLOAITIENTE1 TBSLOAITIENTE1_0_ ");

		queryBuilder.append("ORDER BY FI_MALOAITT ASC");


		Query query = mEntityManager.createNativeQuery(queryBuilder.toString(), LoaiTienTe1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		return query.getResultList();
	}

}