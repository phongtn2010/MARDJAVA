package com.nsw.backend.vroot.repositories;


import com.nsw.backend.vroot.model.TBSDANHMUC25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface TBSDANHMUC25Repository extends JpaRepository<TBSDANHMUC25, Long>, JpaSpecificationExecutor<TBSDANHMUC25> {
    public List<TBSDANHMUC25> findByFiCatNoOrderByFiOrder(Long fiCatNo);
    public List<TBSDANHMUC25> findByFiCatParentOrderByFiOrder(Long id);
    @Query(value = "SELECT max(fiCatType) FROM TBSDANHMUC25 where fiCatNo=?1")
    public Long findFiMaxCatTypeByFiCatNo(Long fiCatNo);
    public List<TBSDANHMUC25> findByFiCatNoAndFiCatType(Long fiCatNo, Long fiCatType);
    public List<TBSDANHMUC25> findByFiCatNoAndFiCatNote(Long fiCatNo, String fiCatNote);
}