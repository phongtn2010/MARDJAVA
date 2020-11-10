package com.nsw.backend.mard.p25.service;

import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p25.model.*;

import java.util.List;

public interface TbdHangHoa25Service {
    public List<TbdHanghoa25> findByFiIdHS(Integer fiIdHS);
    public void save(TbdHanghoa25 tbdHanghoa25);
    public TbdHanghoa25 findByFiIdProduct(Integer id);
    public void saveAll(List<TbdHanghoa25> tbdHanghoa25s);
    FilterResultHH searchHangHoa(FilterHangHoa filterHangHoa);
    public List<TbdHanghoa25> findByFiTaxCodeAndFiTrangThaiHangHoa(String taxcode, Integer fiTrangThai);
//    LoadingCache<String, Boolean> getSignPendingProfiles();
//    void rollbackFailedRequestUpdate(String nswFileCode);
}
