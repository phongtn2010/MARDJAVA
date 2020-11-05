package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdHanghoa25;

import java.util.List;

public interface TbdHangHoa25Service {
    public List<TbdHanghoa25> findByFiIdHS(Integer fiIdHS);
    public void save(TbdHanghoa25 tbdHanghoa25);
    public TbdHanghoa25 findByFiIdProduct(Integer id);
}
