package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.Tbdtbap01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdApphi01Repository extends JpaRepository<Tbdtbap01, Long> {
}
