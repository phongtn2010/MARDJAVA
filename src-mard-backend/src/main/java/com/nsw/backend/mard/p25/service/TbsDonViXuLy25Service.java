package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbsDonViXuLy25;

import java.util.List;

public interface TbsDonViXuLy25Service {
    public List<TbsDonViXuLy25> findByFiPUType(Integer fiPuType);
}
