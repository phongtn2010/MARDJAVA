package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class CuaKhau1RepositoryImpl implements CuaKhau1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private CuaKhau1Repository mCuaKhau1Repository;

	@Override
	public CuaKhau1 getCuaKhau1(long primaryKey) {

		return mCuaKhau1Repository.findOne(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CuaKhau1> getByMaChiNhanhs(String maChiNhanh) {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBSCUAKHAU1_0_.* ");
		queryBuilder.append("FROM SBV.TBSCUAKHAU1 TBSCUAKHAU1_0_ ");

		queryBuilder.append("WHERE ");

		queryBuilder.append("(" + FI_MACHINHANH + "=:FI_MACHINHANH) AND  ");
		paramValues.put(FI_MACHINHANH, maChiNhanh);


		String sql = queryBuilder.toString().trim();

		if (sql.endsWith("AND")) {

			sql = sql.substring(0, sql.length() - 3);

		}

		if (sql.endsWith("WHERE")) {

			sql = sql.substring(0, sql.length() - 5);

		}

		sql += "  ORDER BY FI_MACHINHANH asc";
		Query query = mEntityManager.createNativeQuery(sql, CuaKhau1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CuaKhau1> getAllCuaKhaus() {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBSCUAKHAU1_0_.* ");
		queryBuilder.append("FROM SBV.TBSCUAKHAU1 TBSCUAKHAU1_0_ ");

		queryBuilder.append("WHERE ");


		String sql = queryBuilder.toString().trim();

		if (sql.endsWith("AND")) {

			sql = sql.substring(0, sql.length() - 3);

		}

		if (sql.endsWith("WHERE")) {

			sql = sql.substring(0, sql.length() - 5);

		}

		sql += "  ORDER BY FI_MACHINHANH asc";
		Query query = mEntityManager.createNativeQuery(sql, CuaKhau1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		return query.getResultList();
	}

	private static final String FI_MACHINHANH = "FI_MACHINHANH";
}