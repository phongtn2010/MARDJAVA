package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TBSDANHMUC25;

import java.util.List;

public interface TbsDanhmuc25Service {
    public List<TBSDANHMUC25> findByFiCatNoOrderByFiOrder(Long fiCatNo);
}
