package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.repositories.TbdHangHoa25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbdHangHoa25ServiceImpl implements TbdHangHoa25Service{
    @Autowired
    private TbdHangHoa25Repository tbdHangHoa25Repository;
    @Override
    public List<TbdHanghoa25> findByFiIdHS(Integer fiIdHS) {
        return tbdHangHoa25Repository.findByFiIdHS(fiIdHS);
    }

    @Override
    public void save(TbdHanghoa25 tbdHanghoa25) {
        tbdHangHoa25Repository.save(tbdHanghoa25);
    }

    @Override
    public TbdHanghoa25 findByFiIdProduct(Integer id) {
        return tbdHangHoa25Repository.findByFiIdProduct(id);
    }
}
