package com.nsw.backend.mard.p08.repositories;

import com.nsw.backend.mard.p08.model.Tbdlichsu08;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tbdlichsu08Repository extends JpaRepository<Tbdlichsu08, Long> {
    Optional<Tbdlichsu08> findByFiIdHst(Long fiIdHst);

    List<Tbdlichsu08> findByFiIdHS(Long fiIdHS);

    List<Tbdlichsu08> findByFiHSCodeOrderByFiCreatedDateDesc(String fiIdHS);

    Page<Tbdlichsu08> findByFiHSCodeOrderByFiCreatedDateDesc(String fiHSCode, Pageable pageRequest);

    Page<Tbdlichsu08> findByFiHSCodeOrderByFiIdHstDesc(String fiHSCode, Pageable pageable);

}
