package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonTienTe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmonTienTeRepository extends JpaRepository<CmonTienTe, Long> {
}