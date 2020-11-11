package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class TepDinhKemHoSo1RepositoryImpl implements TepDinhKemHoSo1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private TepDinhKemHoSo1Repository mTepDinhKemHoSo1Repository;

	@Override
	public TepDinhKemHoSo1 createTepDinhKemHoSo1(TepDinhKemHoSo1 pTepDinhKemHoSo1) {

		return mTepDinhKemHoSo1Repository.save(pTepDinhKemHoSo1);
	}

	@Override
	public TepDinhKemHoSo1 updateTepDinhKemHoSo1(long primaryKey, TepDinhKemHoSo1 pTepDinhKemHoSo1) {

		return mTepDinhKemHoSo1Repository.save(pTepDinhKemHoSo1);
	}

	@Override
	public boolean deleteTepDinhKemHoSo1(TepDinhKemHoSo1 pTepDinhKemHoSo1) {

		 mTepDinhKemHoSo1Repository.delete(pTepDinhKemHoSo1);
		return true;
	}

	@Override
	public TepDinhKemHoSo1 getTepDinhKemHoSo1(long primaryKey) {

		return mTepDinhKemHoSo1Repository.findOne(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TepDinhKemHoSo1> getByTepDinhKems(long idHoSo) {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBDTEPDINHKEMHOSO1_0_.* ");
		queryBuilder.append("FROM SBV.TBDTEPDINHKEMHOSO1 TBDTEPDINHKEMHOSO1_0_ ");

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

		sql += "  ORDER BY PK_IDTEPDK ASC";
		Query query = mEntityManager.createNativeQuery(sql, TepDinhKemHoSo1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		return query.getResultList();
	}

	private static final String FI_IDHOSO = "FI_IDHOSO";
}