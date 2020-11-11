package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class TrangThai1RepositoryImpl implements TrangThai1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private TrangThai1Repository mTrangThai1Repository;

	@Override
	public TrangThai1 getTrangThai1(long primaryKey) {

		return mTrangThai1Repository.findOne(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThai1> getAllTrangThai1s() {

		Query query = mEntityManager.createNamedQuery("FIND_ALL", TrangThai1.class);

		return query.getResultList();
	}

}