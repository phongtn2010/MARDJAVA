package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HoSoNgoaiTe1ServiceImpl implements HoSoNgoaiTe1Service {

	@Autowired
	private HoSoNgoaiTe1Repository mHoSoNgoaiTe1Repository;

	@Override
	public HoSoNgoaiTe1 createHoSoNgoaiTe1(HoSoNgoaiTe1 pHoSoNgoaiTe1) {

		return mHoSoNgoaiTe1Repository.createHoSoNgoaiTe1(pHoSoNgoaiTe1);
	}

	@Override
	public HoSoNgoaiTe1 updateHoSoNgoaiTe1(long primaryKey, HoSoNgoaiTe1 pHoSoNgoaiTe1) {

		return mHoSoNgoaiTe1Repository.updateHoSoNgoaiTe1(primaryKey, pHoSoNgoaiTe1);
	}

	@Override
	public boolean deleteHoSoNgoaiTe1(HoSoNgoaiTe1 pHoSoNgoaiTe1) {

		return mHoSoNgoaiTe1Repository.deleteHoSoNgoaiTe1(pHoSoNgoaiTe1);
	}

	@Override
	public HoSoNgoaiTe1 getHoSoNgoaiTe1(long primaryKey) {

		return mHoSoNgoaiTe1Repository.getHoSoNgoaiTe1(primaryKey);
	}

	@Override
	public HoSoNgoaiTe1 findByMaHoSo(String maHoSo) {

		return mHoSoNgoaiTe1Repository.findByMaHoSo(maHoSo);
	}

	@Override
	public List<HoSoNgoaiTe1> searchHoSos(HoSoNgoaiTe1SearchItem item) {

		return mHoSoNgoaiTe1Repository.searchHoSos(item);
	}

	@Override
	public long countHoSos(HoSoNgoaiTe1SearchItem item) {

		return mHoSoNgoaiTe1Repository.countHoSos(item);
	}


}