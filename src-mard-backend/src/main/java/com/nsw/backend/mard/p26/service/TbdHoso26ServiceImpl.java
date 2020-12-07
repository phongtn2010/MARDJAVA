package com.nsw.backend.mard.p26.service;

import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p26.constant.Constant26;
import com.nsw.backend.mard.p26.model.FilterForm;
import com.nsw.backend.mard.p26.model.FilterResult;
import com.nsw.backend.mard.p26.model.TbdHoso26;
import com.nsw.backend.mard.p26.repositories.TbdHoso26Repository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TbdHoso26ServiceImpl implements TbdHoso26Service{
    @Autowired
    private TbdHoso26Repository repository;

    private String generateMaHoso(long id) {
        //HSCode Pattern: {Ministry's name}{Year[4]}{ID of HS[7]}
        return String.format("%s%04d%07d",
                Constant26.NSWFILECODE,
                Calendar.getInstance().get(Calendar.YEAR),
                id);
    }

    @Override
    public TbdHoso26 update(TbdHoso26 tbdHoso26) {
        repository.save(tbdHoso26);
        return tbdHoso26;
    }

    @Override
    public TbdHoso26 create(TbdHoso26 tbdHoso26) {
        TbdHoso26 entity = repository.save(tbdHoso26);
        if (StringUtils.isEmpty(tbdHoso26.getFiMaHoso())) {
            entity.setFiMaHoso(generateMaHoso(entity.getFiIdHoSo26()));
        }

        return repository.save(entity);
    }

    @Override
    public FilterResult searchHoso(FilterForm filterForm) {
        return repository.searchHoso(filterForm);
    }

    @Override
    public TbdHoso26 findById(int parseInt) {
        return repository.findByFiIdHoSo26(parseInt);
    }

    @Override
    public TbdHoso26 findByFiHSCode(String nswFileCode) {
        return repository.findByFiMaHoso(nswFileCode);
    }

    @Override
    public List<TbdHoso26> findCongVanMienKiem(Date now, String taxcode) {
        return repository.findCongVanMienKiem(now,taxcode);
    }
}
