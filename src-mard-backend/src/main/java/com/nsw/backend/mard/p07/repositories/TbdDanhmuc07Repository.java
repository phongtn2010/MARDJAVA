package com.nsw.backend.mard.p07.repositories;

import com.nsw.backend.mard.p07.model.TbdDanhmuc07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository : TbdTbapphi09.
 */

@Repository
public interface TbdDanhmuc07Repository extends JpaRepository<TbdDanhmuc07, Long> {
    List<TbdDanhmuc07> findAllByFiTypeOrderByFiName(String fiType);
}

