package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface CuaKhau1RepositoryCustom {

	public CuaKhau1 getCuaKhau1(long primaryKey);
	public List<CuaKhau1> getByMaChiNhanhs(String maChiNhanh);
	public List<CuaKhau1> getAllCuaKhaus();
}