package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TBSDANHMUC25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TBSDANHMUC25Repository extends JpaRepository<TBSDANHMUC25, Long>, JpaSpecificationExecutor<TBSDANHMUC25> {
    public List<TBSDANHMUC25> findByFiCatNoOrderByFiOrder(Long fiCatNo);
}