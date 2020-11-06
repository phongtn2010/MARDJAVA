package com.nsw.backend.mard.p25.service;

import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p25.model.TbdLichSuHH25;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface TbdLichSuHH25Service {
    void save(TbdLichSuHH25 tbdLichSuHH25);

    List<TbdLichSuHH25> findByfiIDHangHoa (Integer fiIdProduct);
    Page<TbdLichSuHH25> findByfiIDHangHoaAndPagable(Integer fiHSCode, PageRequest pageRequest);
}
