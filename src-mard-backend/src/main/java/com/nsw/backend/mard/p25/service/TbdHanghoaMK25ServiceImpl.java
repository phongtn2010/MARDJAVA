package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.dto.FilterFormHangHoaMK25;
import com.nsw.backend.mard.p25.dto.FilterResultHangHoaMK25;
import com.nsw.backend.mard.p25.model.TbdHanghoaMK25;
import com.nsw.backend.mard.p25.repositories.TbdHanghoaMK25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbdHanghoaMK25ServiceImpl implements TbdHanghoaMK25Service {
    @Autowired
    private TbdHanghoaMK25Repository tbdHanghoaMK25Repository;

    @Override
    public List<TbdHanghoaMK25> findByFiTaxCode(String taxCode) {
        return tbdHanghoaMK25Repository.findByFiTaxCode(taxCode);
    }

    @Override
    public List<TbdHanghoaMK25> findByFiProHash(String hash) {
        return tbdHanghoaMK25Repository.findByFiProHash(hash);
    }
    @Override
    public void save(TbdHanghoaMK25 tbdHanghoaMK25){
        tbdHanghoaMK25Repository.save(tbdHanghoaMK25);
    }

    @Override
    public TbdHanghoaMK25 findByFiIdProduct(Integer fiIdProduct) {
        return tbdHanghoaMK25Repository.findByFiIdProduct(fiIdProduct);
    }

    @Override
    public FilterResultHangHoaMK25 searchHanghoaMK25(FilterFormHangHoaMK25 filter) {
        return tbdHanghoaMK25Repository.searchHanghoaMK25(filter);
    }
}
