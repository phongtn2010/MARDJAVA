package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdChiTieuDG25;

import java.util.List;

public interface TbdChiTieuDG25Service {
    void save(TbdChiTieuDG25 tbdChiTieuDG25);
    List<TbdChiTieuDG25> findByFiNSWFileCode(String fiNSWFileCode);
    List<TbdChiTieuDG25> findByFiIdProduct(Integer id);
}
