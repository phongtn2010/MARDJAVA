package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface TrangThai1RepositoryCustom {

	public TrangThai1 getTrangThai1(long primaryKey);
	public List<TrangThai1> getAllTrangThai1s();
	
}