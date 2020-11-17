package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class YeuCauHuyHoSo1RepositoryImpl implements YeuCauHuyHoSo1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private YeuCauHuyHoSo1Repository mYeuCauHuyHoSo1Repository;

	@Override
	public YeuCauHuyHoSo1 createYeuCauHuyHoSo1(YeuCauHuyHoSo1 pYeuCauHuyHoSo1) {

		return mYeuCauHuyHoSo1Repository.save(pYeuCauHuyHoSo1);
	}

	@Override
	public YeuCauHuyHoSo1 updateYeuCauHuyHoSo1(long primaryKey, YeuCauHuyHoSo1 pYeuCauHuyHoSo1) {

		return mYeuCauHuyHoSo1Repository.save(pYeuCauHuyHoSo1);
	}

	@Override
	public boolean deleteYeuCauHuyHoSo1(YeuCauHuyHoSo1 pYeuCauHuyHoSo1) {

		 mYeuCauHuyHoSo1Repository.delete(pYeuCauHuyHoSo1);
		return true;
	}

	@Override
	public YeuCauHuyHoSo1 getYeuCauHuyHoSo1(long primaryKey) {

		return mYeuCauHuyHoSo1Repository.findOne(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<YeuCauHuyHoSo1> getYeuCauHuyHoSo1s(long idHoSo) {

		StringBuilder queryBuilder = new StringBuilder();
		Map<String, Object> paramValues = new HashMap<>();

		queryBuilder.append("SELECT TBDYEUCAUHUYHOSO1_0_.* ");
		queryBuilder.append("FROM SBV.TBDYEUCAUHUYHOSO1 TBDYEUCAUHUYHOSO1_0_ ");

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

		sql += "  ORDER BY PK_IDYEUCAUHUYHS DESC";
		Query query = mEntityManager.createNativeQuery(sql, YeuCauHuyHoSo1.class);

		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			query.setParameter(key, value);
		}

		return query.getResultList();
	}

	private static final String FI_IDHOSO = "FI_IDHOSO";
}