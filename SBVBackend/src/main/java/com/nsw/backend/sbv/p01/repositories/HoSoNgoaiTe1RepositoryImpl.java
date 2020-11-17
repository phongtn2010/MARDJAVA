package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;

import java.util.Collections;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HoSoNgoaiTe1RepositoryImpl implements HoSoNgoaiTe1RepositoryCustom {

	@PersistenceContext
	private EntityManager mEntityManager;

	@Autowired
	private HoSoNgoaiTe1Repository mHoSoNgoaiTe1Repository;

	@Override
	public HoSoNgoaiTe1 createHoSoNgoaiTe1(HoSoNgoaiTe1 pHoSoNgoaiTe1) {

		return mHoSoNgoaiTe1Repository.save(pHoSoNgoaiTe1);
	}

	@Override
	public HoSoNgoaiTe1 updateHoSoNgoaiTe1(long primaryKey, HoSoNgoaiTe1 pHoSoNgoaiTe1) {

		return mHoSoNgoaiTe1Repository.save(pHoSoNgoaiTe1);
	}

	@Override
	public boolean deleteHoSoNgoaiTe1(HoSoNgoaiTe1 pHoSoNgoaiTe1) {

		mHoSoNgoaiTe1Repository.delete(pHoSoNgoaiTe1);
		return true;
	}

	@Override
	public HoSoNgoaiTe1 getHoSoNgoaiTe1(long primaryKey) {

		return mHoSoNgoaiTe1Repository.findOne(primaryKey);
	}

	@Override
	public List<HoSoNgoaiTe1> searchHoSos(HoSoNgoaiTe1SearchItem item) {

		
		return Collections.emptyList();
	}

	@Override
	public long countHoSos(HoSoNgoaiTe1SearchItem item) {

		return 0;
	}

}