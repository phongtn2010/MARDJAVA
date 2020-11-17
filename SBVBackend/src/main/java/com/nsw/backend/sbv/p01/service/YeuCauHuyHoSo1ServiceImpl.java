package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class YeuCauHuyHoSo1ServiceImpl implements YeuCauHuyHoSo1Service {

	@Autowired
	private YeuCauHuyHoSo1Repository mYeuCauHuyHoSo1Repository;

	@Override
	public YeuCauHuyHoSo1 createYeuCauHuyHoSo1(YeuCauHuyHoSo1 pYeuCauHuyHoSo1) {

		return mYeuCauHuyHoSo1Repository.createYeuCauHuyHoSo1(pYeuCauHuyHoSo1);
	}

	@Override
	public YeuCauHuyHoSo1 updateYeuCauHuyHoSo1(long primaryKey, YeuCauHuyHoSo1 pYeuCauHuyHoSo1) {

		return mYeuCauHuyHoSo1Repository.updateYeuCauHuyHoSo1(primaryKey, pYeuCauHuyHoSo1);
	}

	@Override
	public boolean deleteYeuCauHuyHoSo1(YeuCauHuyHoSo1 pYeuCauHuyHoSo1) {

		return mYeuCauHuyHoSo1Repository.deleteYeuCauHuyHoSo1(pYeuCauHuyHoSo1);
	}

	@Override
	public YeuCauHuyHoSo1 getYeuCauHuyHoSo1(long primaryKey) {

		return mYeuCauHuyHoSo1Repository.getYeuCauHuyHoSo1(primaryKey);
	}

	@Override
	public List<YeuCauHuyHoSo1> getYeuCauHuyHoSo1s(long idHoSo) {

		return mYeuCauHuyHoSo1Repository.getYeuCauHuyHoSo1s(idHoSo);
	}

}