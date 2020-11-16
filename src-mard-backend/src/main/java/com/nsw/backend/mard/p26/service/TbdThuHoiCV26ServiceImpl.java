package com.nsw.backend.mard.p26.service;

import com.nsw.backend.mard.p26.model.TbdThuHoiCV26;
import com.nsw.backend.mard.p26.repositories.TbdThuHoiCV26Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TbdThuHoiCV26ServiceImpl implements TbdThuHoiCV26Service{
    @Autowired
    private TbdThuHoiCV26Repository repository;
    @Override
    public void save(TbdThuHoiCV26 tbdThuHoiCV26) {
        repository.save(tbdThuHoiCV26);
    }
}
