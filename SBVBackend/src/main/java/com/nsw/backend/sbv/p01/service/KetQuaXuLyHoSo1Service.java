package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface KetQuaXuLyHoSo1Service {

	public KetQuaXuLyHoSo1 createKetQuaXuLyHoSo1(KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1);
	public KetQuaXuLyHoSo1 updateKetQuaXuLyHoSo1(long primaryKey, KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1);
	public boolean deleteKetQuaXuLyHoSo1(KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1);
	public KetQuaXuLyHoSo1 getKetQuaXuLyHoSo1(long primaryKey);
	public List<KetQuaXuLyHoSo1> searchKetQuaXuLys(long idHoSo, int pageIndex, int pageSize);
	public long countKetQuaXuLys(long idHoSo);
}