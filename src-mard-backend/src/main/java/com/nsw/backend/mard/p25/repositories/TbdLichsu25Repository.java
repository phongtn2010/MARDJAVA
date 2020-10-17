package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdLichsu25;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TbdLichsu25Repository extends JpaRepository<TbdLichsu25, Integer> {
    Optional<TbdLichsu25> findByFiIdHst(Integer fiIdHst);

    List<TbdLichsu25> findByFiIdHS(Integer fiIdHS);

    List<TbdLichsu25> findByFiHSCodeOrderByFiCreatedDateDesc(String fiIdHS);

    Page<TbdLichsu25> findByFiHSCodeOrderByFiIdHstDesc(String fiHSCode, Pageable pageable);
}
