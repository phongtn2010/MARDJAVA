package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.TbsTepDinhKem1;

import java.util.List;

public interface TbsTepDinhKem1Service {
    /**
     * @param tepDinhKemId - Type: Long
     * @return may can null
     */
    public TbsTepDinhKem1 findOne(Long tepDinhKemId);


    /**
     * @param loaiThuTuc - Type: String
     * @return can return null or throw exception
     */
    List<TbsTepDinhKem1> findByLoaiThuTuc(String loaiThuTuc);

    List<TbsTepDinhKem1> findByLoaiThuTucAndLoaiTep(String loaiThuTuc, String loaiTep);
}
