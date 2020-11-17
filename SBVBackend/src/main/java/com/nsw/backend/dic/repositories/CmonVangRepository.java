package com.nsw.backend.dic.repositories;


import com.nsw.backend.dic.model.CmonVang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmonVangRepository extends JpaRepository<CmonVang, Long> {
}