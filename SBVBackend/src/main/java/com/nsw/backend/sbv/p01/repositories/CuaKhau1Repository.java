package com.nsw.backend.sbv.p01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nsw.backend.sbv.p01.model.*;

@Repository
public interface CuaKhau1Repository  extends JpaRepository<CuaKhau1, Long>, CuaKhau1RepositoryCustom {

	public CuaKhau1 findByMaCuaKhau(String maCuaKhau);
}