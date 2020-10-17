package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.TbdTbXncl09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbdTbXNCL09Repository extends JpaRepository<TbdTbXncl09, Long> {
    List<TbdTbXncl09> findAllByFiNSWFileCodeOrderByFiIdTbDesc(String fiHSCode);
}
