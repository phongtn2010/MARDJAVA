package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbsDonViXuLy25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbsDonViXuLy25Repository extends JpaRepository<TbsDonViXuLy25, Integer>, JpaSpecificationExecutor<TbsDonViXuLy25> {
    public List<TbsDonViXuLy25> findByFiPUType(Integer fiPuType);
}
