package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdXacNhanDon25;

public interface TbdXacNhanDon25Service {
    void save(TbdXacNhanDon25 tbdXacNhanDon25);
    TbdXacNhanDon25 findByFiNSWFileCode(String fiNSWFileCode);
}
