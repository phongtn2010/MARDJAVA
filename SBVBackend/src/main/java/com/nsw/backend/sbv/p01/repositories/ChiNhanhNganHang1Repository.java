package com.nsw.backend.sbv.p01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nsw.backend.sbv.p01.model.*;

@Repository
public interface ChiNhanhNganHang1Repository  extends JpaRepository<ChiNhanhNganHang1, Long>, ChiNhanhNganHang1RepositoryCustom {

	public ChiNhanhNganHang1 findByMaChiNhanh(String maChiNhanh);
}