package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class KetQuaXuLyHoSo1ServiceImpl implements KetQuaXuLyHoSo1Service {

	@Autowired
	private KetQuaXuLyHoSo1Repository mKetQuaXuLyHoSo1Repository;

	@Override
	public KetQuaXuLyHoSo1 createKetQuaXuLyHoSo1(KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1) {

		return mKetQuaXuLyHoSo1Repository.createKetQuaXuLyHoSo1(pKetQuaXuLyHoSo1);
	}

	@Override
	public KetQuaXuLyHoSo1 updateKetQuaXuLyHoSo1(long primaryKey, KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1) {

		return mKetQuaXuLyHoSo1Repository.updateKetQuaXuLyHoSo1(primaryKey, pKetQuaXuLyHoSo1);
	}

	@Override
	public boolean deleteKetQuaXuLyHoSo1(KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1) {

		return mKetQuaXuLyHoSo1Repository.deleteKetQuaXuLyHoSo1(pKetQuaXuLyHoSo1);
	}

	@Override
	public KetQuaXuLyHoSo1 getKetQuaXuLyHoSo1(long primaryKey) {

		return mKetQuaXuLyHoSo1Repository.getKetQuaXuLyHoSo1(primaryKey);
	}

	@Override
	public List<KetQuaXuLyHoSo1> searchKetQuaXuLys(long idHoSo, int pageIndex, int pageSize) {

		return mKetQuaXuLyHoSo1Repository.searchKetQuaXuLys(idHoSo, pageIndex, pageSize);
	}

	@Override
	public long countKetQuaXuLys(long idHoSo) {

		return mKetQuaXuLyHoSo1Repository.countKetQuaXuLys(idHoSo);
	}

}