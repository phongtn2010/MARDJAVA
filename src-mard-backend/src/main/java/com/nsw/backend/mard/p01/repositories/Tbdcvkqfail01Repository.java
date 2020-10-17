package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.Tbdcvkqfail01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Tbdcvkqfail01Repository extends JpaRepository<Tbdcvkqfail01, Long> {

    Optional<Tbdcvkqfail01> findFirstByFiNSWFileCode(String fiNSWFileCode);
}
