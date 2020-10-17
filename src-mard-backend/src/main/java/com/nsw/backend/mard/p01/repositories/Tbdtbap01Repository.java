package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.Tbdtbap01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository : Tbdtbap01
 */
@Repository
public interface Tbdtbap01Repository extends JpaRepository<Tbdtbap01, Long> {
    List<Tbdtbap01> findAllByFiNSWFileCodeOrderByFiCreatedDateAsc(String fiNSWFileCode);
}
