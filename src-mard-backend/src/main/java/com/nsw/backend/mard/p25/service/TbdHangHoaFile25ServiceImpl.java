package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdHangHoaFile25;
import com.nsw.backend.mard.p25.repositories.TbdHangHoaFile25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbdHangHoaFile25ServiceImpl implements TbdHangHoaFile25Service{
    @Autowired
    private TbdHangHoaFile25Repository repository;
    @Override
    public void update(TbdHangHoaFile25 tbdHangHoaFile25){
        repository.save(tbdHangHoaFile25);
    }

    @Override
    public void saveAll(List<TbdHangHoaFile25> lstTbdHangHoaFile25s) {
        repository.save(lstTbdHangHoaFile25s);
    }

    @Override
    public List<TbdHangHoaFile25> findByFiIDHangHoa(Integer idHangHoa) {
        return repository.findByFiIDHangHoa(idHangHoa);
    }
}
