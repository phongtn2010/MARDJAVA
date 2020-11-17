package com.nsw.backend.sbv.p02.service;

import com.nsw.backend.sbv.p02.constant.Constant02;
import com.nsw.backend.sbv.p02.model.TbdHosovang2;
import com.nsw.backend.sbv.p02.repositories.TbdHosovang2Repository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Calendar;

@Service
@Transactional
public class TbdHosovang2ServiceImpl implements TbdHosovang2Service {

    private final TbdHosovang2Repository regProfileRepository;

    @Autowired
    public TbdHosovang2ServiceImpl(TbdHosovang2Repository regProfileRepository) {
        this.regProfileRepository = regProfileRepository;
    }

    @Override
    public TbdHosovang2 save(TbdHosovang2 entity) {
        entity = regProfileRepository.save(entity);
        if (StringUtils.isEmpty(entity.getFiNSWFileCode())) {
            entity.setFiNSWFileCode(generateMaHoso(entity.getFiIdHS()));
        }
        return regProfileRepository.save(entity);
    }

    @Override
    public TbdHosovang2 create(TbdHosovang2 entity) {
        entity.setFiActive(true);
        entity.setFiIdTrangThai(0);
        return this.save(entity);
    }

    private String generateMaHoso(long id) {
        //HSCode Pattern: {Ministry's name}{ProcedureCode[2]}{Year[2]}{ID of HS[7]}
        return String.format("%s%s%02d%07d",
                Constant02.MINISTRY_NAME,
                Constant02.SBV_PROC_CODE,
                Calendar.getInstance().get(Calendar.YEAR) % 100,
                id);
    }
}
