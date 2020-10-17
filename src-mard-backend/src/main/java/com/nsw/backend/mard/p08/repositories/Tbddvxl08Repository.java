package com.nsw.backend.mard.p08.repositories;

import com.nsw.backend.mard.p08.model.Tbddvxl08;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository : Tbddvxl08
 */
@Repository
public interface Tbddvxl08Repository extends JpaRepository<Tbddvxl08, Long> {
    List<Tbddvxl08> findAllByFiPULevel(int level);

    Optional<Tbddvxl08> findByFiPUCode(String puCode);
}
