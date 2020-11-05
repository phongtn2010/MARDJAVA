package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdChiTieuDG25;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdChiTieuDG25Repository extends JpaRepository<TbdChiTieuDG25, Integer> {
}
