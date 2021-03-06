package com.nsw.backend.mard.p07.repositories;

import com.nsw.backend.mard.p07.model.TbdYcsua07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository : TbdYcrut07.
 */

@Repository
public interface TbdYcsua07Repository extends JpaRepository<TbdYcsua07, Long> {
    List<TbdYcsua07> findAllByFiNSWFileCode(String fiNSWFileCode);
}

