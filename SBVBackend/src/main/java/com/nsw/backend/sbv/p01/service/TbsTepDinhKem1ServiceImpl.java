package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.TbsTepDinhKem1;
import com.nsw.backend.sbv.p01.repositories.TbsTepDinhKem1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *
 *
 * @Service
 * @class TbsTepDinhKem1ServiceImpl
 * Created by Nguyen Van Quang
 * 22/08/2018 13:00:07
 *
 */
@Service
public class TbsTepDinhKem1ServiceImpl implements TbsTepDinhKem1Service {

    @Autowired
    private TbsTepDinhKem1Repository tbsTepDinhKem1Repository;

    @Override
    public TbsTepDinhKem1 findOne(Long tepDinhKemId) {

        TbsTepDinhKem1 tbsTepDinhKem1 = tbsTepDinhKem1Repository.findOne(tepDinhKemId);
        if (tbsTepDinhKem1 == null)
            throw new RuntimeException(TbsTepDinhKem1.class.getSimpleName() + " not found " + tepDinhKemId);
        return tbsTepDinhKem1;
    }

    @Override
    public List<TbsTepDinhKem1> findByLoaiThuTuc(String loaiThuTuc) {

        return tbsTepDinhKem1Repository.findByLoaiThuTucOrderByOrderAsc(loaiThuTuc);
    }

    @Override
    public List<TbsTepDinhKem1> findByLoaiThuTucAndLoaiTep(String loaiThuTuc, String loaiTep) {
        return tbsTepDinhKem1Repository.findByLoaiThuTucAndLoaiTepOrderByOrderAsc(loaiThuTuc, loaiTep);
    }


}
