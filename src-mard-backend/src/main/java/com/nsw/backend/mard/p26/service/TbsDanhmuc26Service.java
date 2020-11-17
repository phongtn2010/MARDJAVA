package com.nsw.backend.mard.p26.service;

import com.nsw.backend.mard.p26.model.TBSDANHMUC26;

import java.util.List;

public interface TbsDanhmuc26Service {
    public List<TBSDANHMUC26> findByFiCatNoOrderByFiOrder(Long fiCatNo);
    public List<TBSDANHMUC26> findByFiCatParentOrderByFiOrder(Long id);
}
