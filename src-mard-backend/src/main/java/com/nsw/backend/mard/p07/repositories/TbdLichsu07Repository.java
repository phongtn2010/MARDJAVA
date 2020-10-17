package com.nsw.backend.mard.p07.repositories;

import com.nsw.backend.mard.p07.model.TbdLichsu07;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TbdLichsu07Repository extends JpaRepository<TbdLichsu07, Long> {
    Optional<TbdLichsu07> findByFiIdHst(Integer fiIdHst);

    List<TbdLichsu07> findByFiIdHS(Integer fiIdHS);

    List<TbdLichsu07> findByFiHSCodeOrderByFiCreatedDateDesc(String fiIdHS);

    Page<TbdLichsu07> findByFiHSCodeOrderByFiIdHstDesc(String fiHSCode, Pageable pageable);
}
