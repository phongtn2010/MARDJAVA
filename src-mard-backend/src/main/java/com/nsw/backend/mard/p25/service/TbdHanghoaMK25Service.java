package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdHanghoaMK25;

import java.util.List;

public interface TbdHanghoaMK25Service {
    List<TbdHanghoaMK25> findByFiTaxCode(String taxCode);
    List<TbdHanghoaMK25> findByFiProHash(String hash);
    void save(TbdHanghoaMK25 tbdHanghoaMK25);
}
