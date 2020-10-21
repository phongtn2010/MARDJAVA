package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdattachHoadon25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbdattachHoadon25Repository extends JpaRepository<TbdattachHoadon25, Long>, JpaSpecificationExecutor<TbdattachHoadon25> {

}