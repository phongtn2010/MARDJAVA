package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdattachHd25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbdattachHd25Repository extends JpaRepository<TbdattachHd25, Long>, JpaSpecificationExecutor<TbdattachHd25> {

}