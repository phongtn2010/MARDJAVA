package com.nsw.backend.mard.p26.repositories;

import com.nsw.backend.mard.p26.model.TBSDANHMUC26;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TBSDANHMUC26Repository extends JpaRepository<TBSDANHMUC26, Long>, JpaSpecificationExecutor<TBSDANHMUC26> {
    public List<TBSDANHMUC26> findByFiCatNoOrderByFiOrder(Long fiCatNo);
    public List<TBSDANHMUC26> findByFiCatParentOrderByFiOrder(Long id);
}