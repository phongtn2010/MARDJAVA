package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdHangHoaFile25;

import java.util.List;

public interface TbdHangHoaFile25Service {
    public void update(TbdHangHoaFile25 tbdHangHoaFile25);
    public void saveAll(List<TbdHangHoaFile25> lstTbdHangHoaFile25s);
    List<TbdHangHoaFile25> findByFiIDHangHoa(Integer idHangHoa);
}
