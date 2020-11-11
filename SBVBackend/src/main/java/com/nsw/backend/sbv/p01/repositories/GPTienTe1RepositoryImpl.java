package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class GPTienTe1RepositoryImpl implements GPTienTe1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private GPTienTe1Repository mGPTienTe1Repository;

	@Override
	public GPTienTe1 createGPTienTe1(GPTienTe1 pGPTienTe1) {

		return mGPTienTe1Repository.save(pGPTienTe1);
	}

	@Override
	public GPTienTe1 updateGPTienTe1(long primaryKey, GPTienTe1 pGPTienTe1) {

		return mGPTienTe1Repository.save(pGPTienTe1);
	}

	@Override
	public boolean deleteGPTienTe1(GPTienTe1 pGPTienTe1) {

		 mGPTienTe1Repository.delete(pGPTienTe1);
		return true;
	}

	@Override
	public GPTienTe1 getGPTienTe1(long primaryKey) {

		return mGPTienTe1Repository.findOne(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GPTienTe1> getByIdCapGXNHoSo() {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBDGPTIENTE1_0_.* ");
		queryBuilder.append("FROM SBV.TBDGPTIENTE1 TBDGPTIENTE1_0_ ");

		queryBuilder.append("WHERE ");


		String sql = queryBuilder.toString().trim();

		if (sql.endsWith("AND")) {

			sql = sql.substring(0, sql.length() - 3);

		}

		if (sql.endsWith("WHERE")) {

			sql = sql.substring(0, sql.length() - 5);

		}

		sql += "  ORDER BY PK_IDTIENTECGXN DESC";
		Query query = mEntityManager.createNativeQuery(sql, GPTienTe1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		return query.getResultList();
	}

}