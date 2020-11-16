package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonDVT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmonDVTRepository extends JpaRepository<CmonDVT, Long> {
}