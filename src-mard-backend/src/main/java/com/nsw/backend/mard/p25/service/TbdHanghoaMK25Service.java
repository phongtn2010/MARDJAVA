package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.dto.FilterFormHangHoaMK25;
import com.nsw.backend.mard.p25.dto.FilterResultHangHoaMK25;
import com.nsw.backend.mard.p25.model.TbdHanghoaMK25;

import java.util.List;

public interface TbdHanghoaMK25Service {
    List<TbdHanghoaMK25> findByFiTaxCode(String taxCode);
    List<TbdHanghoaMK25> findByFiProHash(String hash);
    void save(TbdHanghoaMK25 tbdHanghoaMK25);
    TbdHanghoaMK25 findByFiIdProduct(Integer fiIdProduct);
    public FilterResultHangHoaMK25 searchHanghoaMK25(FilterFormHangHoaMK25 filter);
}
