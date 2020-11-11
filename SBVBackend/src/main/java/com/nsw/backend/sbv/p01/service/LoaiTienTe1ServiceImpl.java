package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class LoaiTienTe1ServiceImpl implements LoaiTienTe1Service {

	@Autowired
	private LoaiTienTe1Repository mLoaiTienTe1Repository;

	@Override
	public LoaiTienTe1 getLoaiTienTe1(long primaryKey) {

		return mLoaiTienTe1Repository.getLoaiTienTe1(primaryKey);
	}

	@Override
	public List<LoaiTienTe1> getAllLoaiTienTe1s() {

		return mLoaiTienTe1Repository.getAllLoaiTienTe1s();
	}

}