package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbsDonViXuLy25;
import com.nsw.backend.mard.p25.repositories.TbsDonViXuLy25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbsDonViXuLy25ServiceImpl implements TbsDonViXuLy25Service {
    @Autowired
    private TbsDonViXuLy25Repository repository;
    @Override
    public List<TbsDonViXuLy25> findByFiPUType(Integer fiPuType) {
        return repository.findByFiPUTypeOrderByFiPUOrder(fiPuType);
    }
}
