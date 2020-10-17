package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.Tbdlichsu01;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Tbdlichsu01Repository extends JpaRepository<Tbdlichsu01, Long> {
    List<Tbdlichsu01> findByFiHSCodeOrderByFiCreatedDateDesc(String fiIdHS);

    Page<Tbdlichsu01> findByFiHSCodeOrderByFiIdHstDesc(String fiHSCode, Pageable pageable);

}
