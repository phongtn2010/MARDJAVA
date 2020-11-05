package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdhosoTccd25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdhosoTccd25Repository extends JpaRepository<TbdhosoTccd25, Integer>, JpaSpecificationExecutor<TbdhosoTccd25> {

}