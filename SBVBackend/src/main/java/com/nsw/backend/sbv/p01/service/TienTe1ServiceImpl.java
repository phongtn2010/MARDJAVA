package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TienTe1ServiceImpl implements TienTe1Service {

	@Autowired
	private TienTe1Repository mTienTe1Repository;

	@Override
	public TienTe1 createTienTe1(TienTe1 pTienTe1) {

		return mTienTe1Repository.createTienTe1(pTienTe1);
	}

	@Override
	public TienTe1 updateTienTe1(long primaryKey, TienTe1 pTienTe1) {

		return mTienTe1Repository.updateTienTe1(primaryKey, pTienTe1);
	}

	@Override
	public boolean deleteTienTe1(TienTe1 pTienTe1) {

		return mTienTe1Repository.deleteTienTe1(pTienTe1);
	}

	@Override
	public TienTe1 getTienTe1(long primaryKey) {

		return mTienTe1Repository.getTienTe1(primaryKey);
	}

	@Override
	public List<TienTe1> getByTienTes(long idHoSo) {

		return mTienTe1Repository.getByTienTes(idHoSo);
	}

}