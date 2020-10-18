package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbsPhannhomtacn25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbsPhannhomtacn25Repository extends JpaRepository<TbsPhannhomtacn25, Long>, JpaSpecificationExecutor<TbsPhannhomtacn25> {

}