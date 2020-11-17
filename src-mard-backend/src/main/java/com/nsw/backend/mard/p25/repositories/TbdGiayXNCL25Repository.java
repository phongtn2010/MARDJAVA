package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdGiayXNCL25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdGiayXNCL25Repository extends JpaRepository<TbdGiayXNCL25, Integer>, JpaSpecificationExecutor<TbdGiayXNCL25> {

}