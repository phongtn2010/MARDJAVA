package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdhosoTccd25;
import com.nsw.backend.mard.p25.repositories.TbdhosoTccd25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbdHosoTccd25ServiceImpl implements TbdHosoTccd25Service {
    @Autowired
    private TbdhosoTccd25Repository repository;
    @Override
    public void save(TbdhosoTccd25 tbdhosoTccd25) {
        repository.save(tbdhosoTccd25);
    }

    @Override
    public List<TbdhosoTccd25> findByFiIdHangHoa(Integer idHangHoa) {
        return repository.findByFiIdHangHoa(idHangHoa);
    }
}
