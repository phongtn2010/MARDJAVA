package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.TbdUOMs01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbdUOMs01Repository extends JpaRepository<TbdUOMs01, Long> {
    List<TbdUOMs01> findAll();
}
