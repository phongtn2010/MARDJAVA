package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;

public interface GiayPhep1Service {

	public GiayPhep1 createGiayPhep1(GiayPhep1 pGiayPhep1);
	public GiayPhep1 updateGiayPhep1(long primaryKey, GiayPhep1 pGiayPhep1);
	public boolean deleteGiayPhep1(GiayPhep1 pGiayPhep1);
	public GiayPhep1 getGiayPhep1(long primaryKey);
	public GiayPhep1 findBySoGiayPhep(String soGiayPhep);
	public GiayPhep1 getByIdHoSo(long idHoSo);
}