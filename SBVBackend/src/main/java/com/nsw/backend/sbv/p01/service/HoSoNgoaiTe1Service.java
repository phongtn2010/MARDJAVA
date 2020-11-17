package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;

import java.util.List;


public interface HoSoNgoaiTe1Service {

	public HoSoNgoaiTe1 createHoSoNgoaiTe1(HoSoNgoaiTe1 pHoSoNgoaiTe1);
	public HoSoNgoaiTe1 updateHoSoNgoaiTe1(long primaryKey, HoSoNgoaiTe1 pHoSoNgoaiTe1);
	public boolean deleteHoSoNgoaiTe1(HoSoNgoaiTe1 pHoSoNgoaiTe1);
	public HoSoNgoaiTe1 getHoSoNgoaiTe1(long primaryKey);
	public HoSoNgoaiTe1 findByMaHoSo(String maHoSo);
	public List<HoSoNgoaiTe1> searchHoSos(HoSoNgoaiTe1SearchItem item);
	public long countHoSos(HoSoNgoaiTe1SearchItem item);
}