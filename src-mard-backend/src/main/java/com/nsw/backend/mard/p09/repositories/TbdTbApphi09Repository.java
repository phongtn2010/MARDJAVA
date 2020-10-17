package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.Tbdtbapphi09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository : TbdTbapphi09.
 */
@Repository
public interface TbdTbApphi09Repository extends JpaRepository<Tbdtbapphi09, Long> {
    List<Tbdtbapphi09> findAllByFiNSWFileCodeOrderByFiCreatedDateAsc(String fiNSWFileCode);
}

