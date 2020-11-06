package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdhosoTccd25;

import java.util.List;

public interface TbdHosoTccd25Service {
    void save(TbdhosoTccd25 tbdhosoTccd25);
    List<TbdhosoTccd25> findByFiIdHangHoa(Integer idHangHoa);
}
