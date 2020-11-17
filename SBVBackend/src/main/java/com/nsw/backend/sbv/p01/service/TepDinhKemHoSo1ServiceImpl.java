package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TepDinhKemHoSo1ServiceImpl implements TepDinhKemHoSo1Service {

	@Autowired
	private TepDinhKemHoSo1Repository mTepDinhKemHoSo1Repository;

	@Override
	public TepDinhKemHoSo1 createTepDinhKemHoSo1(TepDinhKemHoSo1 pTepDinhKemHoSo1) {

		return mTepDinhKemHoSo1Repository.createTepDinhKemHoSo1(pTepDinhKemHoSo1);
	}

	@Override
	public TepDinhKemHoSo1 updateTepDinhKemHoSo1(long primaryKey, TepDinhKemHoSo1 pTepDinhKemHoSo1) {

		return mTepDinhKemHoSo1Repository.updateTepDinhKemHoSo1(primaryKey, pTepDinhKemHoSo1);
	}

	@Override
	public boolean deleteTepDinhKemHoSo1(TepDinhKemHoSo1 pTepDinhKemHoSo1) {

		return mTepDinhKemHoSo1Repository.deleteTepDinhKemHoSo1(pTepDinhKemHoSo1);
	}

	@Override
	public TepDinhKemHoSo1 getTepDinhKemHoSo1(long primaryKey) {

		return mTepDinhKemHoSo1Repository.getTepDinhKemHoSo1(primaryKey);
	}

	@Override
	public List<TepDinhKemHoSo1> getByTepDinhKems(long idHoSo) {

		return mTepDinhKemHoSo1Repository.getByTepDinhKems(idHoSo);
	}

	@Override
	public long sizeOfFiles(long idHoSo) {
		Optional<Long> optional = mTepDinhKemHoSo1Repository.sizeOfFiles(idHoSo);
		if (optional.isPresent()) return optional.get();
		return 0;
	}

}