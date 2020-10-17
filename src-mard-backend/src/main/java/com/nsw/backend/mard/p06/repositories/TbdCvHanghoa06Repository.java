package com.nsw.backend.mard.p06.repositories;

import com.nsw.backend.mard.p06.model.TbdCvHanghoa06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TbdCvHanghoa06Repository extends JpaRepository<TbdCvHanghoa06, Long> {

    Optional<TbdCvHanghoa06> findByFiId(int parseInt);

    List<TbdCvHanghoa06> findAllByFiPackageUnitCode(String unitCode);
}
