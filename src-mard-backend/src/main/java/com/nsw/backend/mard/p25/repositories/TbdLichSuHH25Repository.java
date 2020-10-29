package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdLichSuHH25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdLichSuHH25Repository  extends JpaRepository<TbdLichSuHH25, Integer>, JpaSpecificationExecutor<TbdLichSuHH25> {
}
