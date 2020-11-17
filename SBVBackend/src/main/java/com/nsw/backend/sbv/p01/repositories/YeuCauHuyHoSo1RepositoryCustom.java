package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface YeuCauHuyHoSo1RepositoryCustom {

	public YeuCauHuyHoSo1 createYeuCauHuyHoSo1(YeuCauHuyHoSo1 pYeuCauHuyHoSo1);
	public YeuCauHuyHoSo1 updateYeuCauHuyHoSo1(long primaryKey, YeuCauHuyHoSo1 pYeuCauHuyHoSo1);
	public boolean deleteYeuCauHuyHoSo1(YeuCauHuyHoSo1 pYeuCauHuyHoSo1);
	public YeuCauHuyHoSo1 getYeuCauHuyHoSo1(long primaryKey);
	public List<YeuCauHuyHoSo1> getYeuCauHuyHoSo1s(long idHoSo);
}