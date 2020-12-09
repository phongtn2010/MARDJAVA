package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdGiayXNCL25;

public interface TbdGiayXNCL25Service {
    TbdGiayXNCL25 save(TbdGiayXNCL25 tbdGiayXNCL25);

    TbdGiayXNCL25 findByFiNSWFileCodeAndFiSoGCN(String fiNSWFileCode, String fiSoGXN);
    TbdGiayXNCL25 findByFiIdHangHoa(Integer fiIdHangHoa);
}
