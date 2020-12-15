package com.nsw.backend.mard.p26.repositories;

import com.nsw.backend.mard.p26.model.TbdLichsu26;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbdLichsu26Repository  extends JpaRepository<TbdLichsu26, Integer> {
    Page<TbdLichsu26> findByFiIdHSOrderByFiCreatedDate(Integer fiIdHS, Pageable pageable);
    List<TbdLichsu26> findByFiIdHS(Integer fiIdHS);
}
