package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ChiNhanhNganHang1ServiceImpl implements ChiNhanhNganHang1Service {

	@Autowired
	private ChiNhanhNganHang1Repository mChiNhanhNganHang1Repository;

	@Override
	public ChiNhanhNganHang1 getChiNhanhNganHang1(long primaryKey) {

		return mChiNhanhNganHang1Repository.getChiNhanhNganHang1(primaryKey);
	}

	@Override
	public ChiNhanhNganHang1 findByMaChiNhanh(String maChiNhanh) {

		return mChiNhanhNganHang1Repository.findByMaChiNhanh(maChiNhanh);
	}

	@Override
	public List<ChiNhanhNganHang1> getAllChiNhanhNganHang1s() {

		return mChiNhanhNganHang1Repository.getAllChiNhanhNganHang1s();
	}

}