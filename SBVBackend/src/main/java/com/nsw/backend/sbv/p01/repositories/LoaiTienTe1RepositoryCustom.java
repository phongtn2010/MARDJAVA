package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface LoaiTienTe1RepositoryCustom {

	public LoaiTienTe1 getLoaiTienTe1(long primaryKey);
	public List<LoaiTienTe1> getAllLoaiTienTe1s();
}