package com.nsw.backend.mard.p06.repositories;

import com.nsw.backend.mard.p06.model.TbdLichsu06;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TbdLichsu06Repository extends JpaRepository<TbdLichsu06, Integer> {
    Optional<TbdLichsu06> findByFiIdHst(Integer fiIdHst);

    List<TbdLichsu06> findByFiIdHS(Integer fiIdHS);

    List<TbdLichsu06> findByFiHSCodeOrderByFiCreatedDateDesc(String fiIdHS);

    Page<TbdLichsu06> findByFiHSCodeOrderByFiIdHstDesc(String fiHSCode, Pageable pageable);

}
