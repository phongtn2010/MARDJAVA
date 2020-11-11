package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TrangThai1ServiceImpl implements TrangThai1Service {

	@Autowired
	private TrangThai1Repository mTrangThai1Repository;

	@Override
	public TrangThai1 getTrangThai1(long primaryKey) {

		return mTrangThai1Repository.getTrangThai1(primaryKey);
	}

	@Override
	public TrangThai1 findByGiaTri(int giaTri) {

		return mTrangThai1Repository.findByGiaTri(giaTri);
	}

	@Override
	public List<TrangThai1> getAllTrangThai1s() {

		return mTrangThai1Repository.getAllTrangThai1s();
	}

}