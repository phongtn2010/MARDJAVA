package com.nsw.backend.mard.p25.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.model.TbdLichSuHH25;
import com.nsw.backend.mard.p25.repositories.TbdLichSuHH25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class TbdLichSuHH25ServiceImpl implements TbdLichSuHH25Service {
    @Autowired
    private TbdLichSuHH25Repository repository;
    @Override
    public void save(TbdLichSuHH25 tbdLichSuHH25) {
        repository.save(tbdLichSuHH25);
    }
    @Override
    public List<TbdLichSuHH25> findByfiIDHangHoa (Integer fiProductId) {
        return repository.findByFiIDHangHoaOrderByFiNgayGuiDesc(fiProductId);
    }
    @Override
    public Page<TbdLichSuHH25> findByfiIDHangHoaAndPagable(Integer fiProductId, PageRequest pageRequest) {
        return repository.findByFiIDHangHoaOrderByFiIdDesc(fiProductId, pageRequest);
    }

}
