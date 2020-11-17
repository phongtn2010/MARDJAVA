package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GiayPhep1ServiceImpl implements GiayPhep1Service {

	@Autowired
	private GiayPhep1Repository mGiayPhep1Repository;

	@Override
	public GiayPhep1 createGiayPhep1(GiayPhep1 pGiayPhep1) {

		return mGiayPhep1Repository.createGiayPhep1(pGiayPhep1);
	}

	@Override
	public GiayPhep1 updateGiayPhep1(long primaryKey, GiayPhep1 pGiayPhep1) {

		return mGiayPhep1Repository.updateGiayPhep1(primaryKey, pGiayPhep1);
	}

	@Override
	public boolean deleteGiayPhep1(GiayPhep1 pGiayPhep1) {

		return mGiayPhep1Repository.deleteGiayPhep1(pGiayPhep1);
	}

	@Override
	public GiayPhep1 getGiayPhep1(long primaryKey) {

		return mGiayPhep1Repository.getGiayPhep1(primaryKey);
	}

	@Override
	public GiayPhep1 findBySoGiayPhep(String soGiayPhep) {

		return mGiayPhep1Repository.findBySoGiayPhep(soGiayPhep);
	}

	@Override
	public GiayPhep1 getByIdHoSo(long idHoSo) {

		return mGiayPhep1Repository.getByIdHoSo(idHoSo);
	}

}