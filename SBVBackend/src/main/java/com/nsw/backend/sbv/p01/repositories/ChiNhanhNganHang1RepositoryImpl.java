package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class ChiNhanhNganHang1RepositoryImpl implements ChiNhanhNganHang1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private ChiNhanhNganHang1Repository mChiNhanhNganHang1Repository;

	@Override
	public ChiNhanhNganHang1 getChiNhanhNganHang1(long primaryKey) {

		return mChiNhanhNganHang1Repository.findOne(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChiNhanhNganHang1> getAllChiNhanhNganHang1s() {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBSCHINHANHNGANHANG1_0_.* ");
		queryBuilder.append("FROM SBV.TBSCHINHANHNGANHANG1 TBSCHINHANHNGANHANG1_0_ ");

		queryBuilder.append("WHERE ");


		String sql = queryBuilder.toString().trim();

		if (sql.endsWith("AND")) {

			sql = sql.substring(0, sql.length() - 3);

		}

		if (sql.endsWith("WHERE")) {

			sql = sql.substring(0, sql.length() - 5);

		}

		sql += "  ORDER BY PK_IDCHINHANHNH DESC";
		Query query = mEntityManager.createNativeQuery(sql, ChiNhanhNganHang1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		return query.getResultList();
	}

}