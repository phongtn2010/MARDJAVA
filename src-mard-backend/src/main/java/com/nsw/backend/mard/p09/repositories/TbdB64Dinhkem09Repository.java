package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.TbdB64Dinhkem09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TbdB64Dinhkem09Repository extends JpaRepository<TbdB64Dinhkem09, Long> {
    Optional<TbdB64Dinhkem09> findByFiIdAndFiTaxCode(long fiId, String fiTaxCode);
}
