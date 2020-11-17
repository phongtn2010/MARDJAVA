package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class TienTe1RepositoryImpl implements TienTe1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private TienTe1Repository mTienTe1Repository;

	@Override
	public TienTe1 createTienTe1(TienTe1 pTienTe1) {

		return mTienTe1Repository.save(pTienTe1);
	}

	@Override
	public TienTe1 updateTienTe1(long primaryKey, TienTe1 pTienTe1) {

		return mTienTe1Repository.save(pTienTe1);
	}

	@Override
	public boolean deleteTienTe1(TienTe1 pTienTe1) {

		 mTienTe1Repository.delete(pTienTe1);
		return true;
	}

	@Override
	public TienTe1 getTienTe1(long primaryKey) {

		return mTienTe1Repository.findOne(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TienTe1> getByTienTes(long idHoSo) {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBDTIENTE1_0_.* ");
		queryBuilder.append("FROM SBV.TBDTIENTE1 TBDTIENTE1_0_ ");

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

		sql += "  ORDER BY PK_IDTIENTE ASC";
		Query query = mEntityManager.createNativeQuery(sql, TienTe1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		return query.getResultList();
	}

	private static final String FI_IDHOSO = "FI_IDHOSO";
}