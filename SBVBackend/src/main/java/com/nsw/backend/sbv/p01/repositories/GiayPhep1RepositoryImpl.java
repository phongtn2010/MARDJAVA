package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class GiayPhep1RepositoryImpl implements GiayPhep1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private GiayPhep1Repository mGiayPhep1Repository;

	@Override
	public GiayPhep1 createGiayPhep1(GiayPhep1 pGiayPhep1) {

		return mGiayPhep1Repository.save(pGiayPhep1);
	}

	@Override
	public GiayPhep1 updateGiayPhep1(long primaryKey, GiayPhep1 pGiayPhep1) {

		return mGiayPhep1Repository.save(pGiayPhep1);
	}

	@Override
	public boolean deleteGiayPhep1(GiayPhep1 pGiayPhep1) {

		 mGiayPhep1Repository.delete(pGiayPhep1);
		return true;
	}

	@Override
	public GiayPhep1 getGiayPhep1(long primaryKey) {

		return mGiayPhep1Repository.findOne(primaryKey);
	}

	@Override
	public GiayPhep1 getByIdHoSo(long idHoSo) {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBDTHONGTINGP1_0_.* ");
		queryBuilder.append("FROM SBV.TBDTHONGTINGP1 TBDTHONGTINGP1_0_ ");

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

		sql += "  ORDER BY PK_IDCAPGXNHS DESC";
		Query query = mEntityManager.createNativeQuery(sql, GiayPhep1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		return (GiayPhep1) query.getSingleResult();
	}

	private static final String FI_IDHOSO = "FI_IDHOSO";
}