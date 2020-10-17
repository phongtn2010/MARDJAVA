package com.nsw.backend.mard.p07.repositories;

import com.nsw.backend.mard.p07.model.TbdHanghoa07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbdHanghoa07Repository extends JpaRepository<TbdHanghoa07, Long> {
    @Query("select hh from TbdHanghoa07 hh where hh.fiQuantityOrWeightUnitCode = ?1")
    List<TbdHanghoa07> findAllByFiQuantityOrWeightUnitCode(String unitCode);
}
