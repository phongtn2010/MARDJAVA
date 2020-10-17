package com.nsw.backend.mard.p07.repositories;

import com.nsw.backend.mard.p07.model.TbdYcrut07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository : TbdYcrut07.
 */

@Repository
public interface TbdYcrut07Repository extends JpaRepository<TbdYcrut07, Long> {
    List<TbdYcrut07> findAllByFiNSWFileCode(String fiNSWFileCode);
}

