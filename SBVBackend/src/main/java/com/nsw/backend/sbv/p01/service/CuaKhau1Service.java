package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface CuaKhau1Service {

	public CuaKhau1 getCuaKhau1(long primaryKey);
	public CuaKhau1 findByMaCuaKhau(String maCuaKhau);
	public List<CuaKhau1> getByMaChiNhanhs(String maChiNhanh);
	public List<CuaKhau1> getAllCuaKhaus();
}