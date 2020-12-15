package com.nsw.backend.mard.p26.service;

import com.nsw.backend.mard.p26.model.TbdLichsu26;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TbdLichsu26Service {
    void save(TbdLichsu26 tbdLichsu26);
    Page<TbdLichsu26> findByFiIdHSOrderByFiCreatedDate(Integer fiIdHS, Pageable pageable);
    List<TbdLichsu26> findByFiIdHS(Integer fiIdHS);
}
