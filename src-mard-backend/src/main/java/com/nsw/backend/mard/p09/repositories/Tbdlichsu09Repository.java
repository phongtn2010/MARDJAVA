package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.Tbdlichsu09;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tbdlichsu09Repository extends JpaRepository<Tbdlichsu09, Long> {

    List<Tbdlichsu09> findByFiHSCodeOrderByFiCreatedDateDesc(String fiIdHS);

    Page<Tbdlichsu09> findByFiHSCodeOrderByFiIdHstDesc(String fiHSCode, Pageable pageable);
}
