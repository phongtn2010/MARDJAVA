package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface ChiNhanhNganHang1Service {

	public ChiNhanhNganHang1 getChiNhanhNganHang1(long primaryKey);
	public ChiNhanhNganHang1 findByMaChiNhanh(String maChiNhanh);
	public List<ChiNhanhNganHang1> getAllChiNhanhNganHang1s();
}