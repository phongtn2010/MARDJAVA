package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface TepDinhKemHoSo1Service {

	public TepDinhKemHoSo1 createTepDinhKemHoSo1(TepDinhKemHoSo1 pTepDinhKemHoSo1);
	public TepDinhKemHoSo1 updateTepDinhKemHoSo1(long primaryKey, TepDinhKemHoSo1 pTepDinhKemHoSo1);
	public boolean deleteTepDinhKemHoSo1(TepDinhKemHoSo1 pTepDinhKemHoSo1);
	public TepDinhKemHoSo1 getTepDinhKemHoSo1(long primaryKey);
	public List<TepDinhKemHoSo1> getByTepDinhKems(long idHoSo);
	long sizeOfFiles(long idHoSo);
}