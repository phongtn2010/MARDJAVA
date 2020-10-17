package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.Tbddvxl01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository : Tbddvxl01
 */
@Repository
public interface Tbddvxl01Repository extends JpaRepository<Tbddvxl01, Long> {
    List<Tbddvxl01> findAllByFiPULevel(int level);
}
