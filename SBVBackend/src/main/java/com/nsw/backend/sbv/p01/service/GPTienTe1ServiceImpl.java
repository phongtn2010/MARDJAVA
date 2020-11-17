package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class GPTienTe1ServiceImpl implements GPTienTe1Service {

	@Autowired
	private GPTienTe1Repository mGPTienTe1Repository;

	@Override
	public GPTienTe1 createGPTienTe1(GPTienTe1 pGPTienTe1) {

		return mGPTienTe1Repository.createGPTienTe1(pGPTienTe1);
	}

	@Override
	public GPTienTe1 updateGPTienTe1(long primaryKey, GPTienTe1 pGPTienTe1) {

		return mGPTienTe1Repository.updateGPTienTe1(primaryKey, pGPTienTe1);
	}

	@Override
	public boolean deleteGPTienTe1(GPTienTe1 pGPTienTe1) {

		return mGPTienTe1Repository.deleteGPTienTe1(pGPTienTe1);
	}

	@Override
	public GPTienTe1 getGPTienTe1(long primaryKey) {

		return mGPTienTe1Repository.getGPTienTe1(primaryKey);
	}

	@Override
	public List<GPTienTe1> getByIdCapGXNHoSo() {

		return mGPTienTe1Repository.getByIdCapGXNHoSo();
	}

}