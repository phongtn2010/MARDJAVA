package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface TrangThai1Service {

	public TrangThai1 getTrangThai1(long primaryKey);
	public TrangThai1 findByGiaTri(int giaTri);
	public List<TrangThai1> getAllTrangThai1s();
}