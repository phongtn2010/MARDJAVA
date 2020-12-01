package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdKQXL25;

public interface TbdKQXL25Service {
    void save(TbdKQXL25 tbdKQXL25);
    TbdKQXL25 findByFiNSWFileCodeAndFiProId(String nswFileCode, Integer proId);
    TbdKQXL25 findByFiNSWFileCodeAndFiSoGCN(String nswFileCode, String soGCN);
}
