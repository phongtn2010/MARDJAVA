package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CmonPortRepository extends JpaRepository<CmonPort, Long> {
}
