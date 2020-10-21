package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.Tbdattach25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Tbdattach25Repository extends JpaRepository<Tbdattach25, Long>, JpaSpecificationExecutor<Tbdattach25> {

}