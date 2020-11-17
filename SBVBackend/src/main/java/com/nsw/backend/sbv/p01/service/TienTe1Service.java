package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface TienTe1Service {

	public TienTe1 createTienTe1(TienTe1 pTienTe1);
	public TienTe1 updateTienTe1(long primaryKey, TienTe1 pTienTe1);
	public boolean deleteTienTe1(TienTe1 pTienTe1);
	public TienTe1 getTienTe1(long primaryKey);
	public List<TienTe1> getByTienTes(long idHoSo);
}