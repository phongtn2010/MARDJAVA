package com.nsw.backend.mard.p07.repositories;

import com.nsw.backend.mard.p07.model.TbdCnkdKd07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbdCnkdKd07Repository extends JpaRepository<TbdCnkdKd07, Long> {
    List<TbdCnkdKd07> findAllByFiNSWFileCodeOrderByFiIdDesc(String fiHSCode);
}
