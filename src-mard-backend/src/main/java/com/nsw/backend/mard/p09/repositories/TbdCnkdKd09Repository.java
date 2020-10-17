package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.TbdCnkdKd09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbdCnkdKd09Repository extends JpaRepository<TbdCnkdKd09, Long> {
    List<TbdCnkdKd09> findAllByFiNSWFileCodeOrderByFiIdDesc(String fiHSCode);
}
