package com.nsw.backend.mard.p25.service;

import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p25.model.FilterForm;
import com.nsw.backend.mard.p25.model.FilterHangHoa;
import com.nsw.backend.mard.p25.model.FilterResult;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;

import java.util.List;

public interface TbdHangHoa25Service {
    public List<TbdHanghoa25> findByFiIdHS(Integer fiIdHS);
    public void save(TbdHanghoa25 tbdHanghoa25);
    public TbdHanghoa25 findByFiIdProduct(Integer id);
    public void saveAll(List<TbdHanghoa25> tbdHanghoa25s);
    FilterResult searchHangHoa(FilterHangHoa filterHangHoa);
//    LoadingCache<String, Boolean> getSignPendingProfiles();
//    void rollbackFailedRequestUpdate(String fiIdHS);
}
