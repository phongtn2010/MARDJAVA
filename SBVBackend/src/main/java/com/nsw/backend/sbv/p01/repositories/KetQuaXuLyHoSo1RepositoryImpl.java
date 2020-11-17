package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.math.BigDecimal;


public class KetQuaXuLyHoSo1RepositoryImpl implements KetQuaXuLyHoSo1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private KetQuaXuLyHoSo1Repository mKetQuaXuLyHoSo1Repository;

	@Override
	public KetQuaXuLyHoSo1 createKetQuaXuLyHoSo1(KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1) {

		return mKetQuaXuLyHoSo1Repository.save(pKetQuaXuLyHoSo1);
	}

	@Override
	public KetQuaXuLyHoSo1 updateKetQuaXuLyHoSo1(long primaryKey, KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1) {

		return mKetQuaXuLyHoSo1Repository.save(pKetQuaXuLyHoSo1);
	}

	@Override
	public boolean deleteKetQuaXuLyHoSo1(KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1) {

		 mKetQuaXuLyHoSo1Repository.delete(pKetQuaXuLyHoSo1);
		return true;
	}

	@Override
	public KetQuaXuLyHoSo1 getKetQuaXuLyHoSo1(long primaryKey) {

		return mKetQuaXuLyHoSo1Repository.findOne(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KetQuaXuLyHoSo1> searchKetQuaXuLys(long idHoSo, int pageIndex, int pageSize) {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBDKETQUAXULYHOSO1_0_.* ");
		queryBuilder.append("FROM SBV.TBDKETQUAXULYHOSO1 TBDKETQUAXULYHOSO1_0_ ");

		queryBuilder.append("WHERE ");

		queryBuilder.append("(" + FI_IDHOSO + "=:FI_IDHOSO) AND  ");
		paramValues.put(FI_IDHOSO, idHoSo);


		String sql = queryBuilder.toString().trim();

		if (sql.endsWith("AND")) {

			sql = sql.substring(0, sql.length() - 3);

		}

		if (sql.endsWith("WHERE")) {

			sql = sql.substring(0, sql.length() - 5);

		}

		sql += "  ORDER BY FI_NGAYTAO DESC";
		Query query = mEntityManager.createNativeQuery(sql, KetQuaXuLyHoSo1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		query.setFirstResult((pageIndex - 1) * pageSize);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@Override
	public long countKetQuaXuLys(long idHoSo) {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT COUNT(*) as total ");
		queryBuilder.append("FROM SBV.TBDKETQUAXULYHOSO1 TBDKETQUAXULYHOSO1_0_ ");

		queryBuilder.append("WHERE ");

		queryBuilder.append("(" + FI_IDHOSO + "=:FI_IDHOSO) AND  ");
		paramValues.put(FI_IDHOSO, idHoSo);


		String sql = queryBuilder.toString().trim();

		if (sql.endsWith("AND")) {

			sql = sql.substring(0, sql.length() - 3);

		}

		if (sql.endsWith("WHERE")) {

			sql = sql.substring(0, sql.length() - 5);

		}
		Query query = mEntityManager.createNativeQuery(sql);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		BigDecimal bigDecimal = (BigDecimal) query.getSingleResult();
		return bigDecimal.longValue();
	}

	private static final String FI_IDHOSO = "FI_IDHOSO";
}