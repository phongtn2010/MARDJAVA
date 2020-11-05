package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdXacNhanDon25;
import com.nsw.backend.mard.p25.repositories.TbdXacNhanDon25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TbdXacNhanDon25ServiceImpl implements TbdXacNhanDon25Service{
    @Autowired
    private TbdXacNhanDon25Repository repository;
    @Override
    public void save(TbdXacNhanDon25 tbdXacNhanDon25) {
        repository.save(tbdXacNhanDon25);
    }

    @Override
    public TbdXacNhanDon25 findByFiNSWFileCode(String fiNSWFileCode) {
        return repository.findByFiNSWFileCode(fiNSWFileCode);
    }
}
