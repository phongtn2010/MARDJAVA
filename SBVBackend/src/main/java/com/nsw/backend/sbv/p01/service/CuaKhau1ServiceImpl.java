package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CuaKhau1ServiceImpl implements CuaKhau1Service {

	@Autowired
	private CuaKhau1Repository mCuaKhau1Repository;

	@Override
	public CuaKhau1 getCuaKhau1(long primaryKey) {

		return mCuaKhau1Repository.getCuaKhau1(primaryKey);
	}

	@Override
	public CuaKhau1 findByMaCuaKhau(String maCuaKhau) {

		return mCuaKhau1Repository.findByMaCuaKhau(maCuaKhau);
	}

	@Override
	public List<CuaKhau1> getByMaChiNhanhs(String maChiNhanh) {

		return mCuaKhau1Repository.getByMaChiNhanhs(maChiNhanh);
	}

	@Override
	public List<CuaKhau1> getAllCuaKhaus() {

		return mCuaKhau1Repository.getAllCuaKhaus();
	}

}