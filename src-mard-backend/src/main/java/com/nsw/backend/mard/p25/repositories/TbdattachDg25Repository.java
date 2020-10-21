package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdattachDg25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbdattachDg25Repository extends JpaRepository<TbdattachDg25, Long>, JpaSpecificationExecutor<TbdattachDg25> {

}