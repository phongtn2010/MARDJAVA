package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdChiTieuDG25;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbdChiTieuDG25Repository extends JpaRepository<TbdChiTieuDG25, Integer> {
    List<TbdChiTieuDG25> findByFiNSWFileCode(String fiNSWFileCode);
    List<TbdChiTieuDG25> findByFiIdProduct(Integer id);
}
