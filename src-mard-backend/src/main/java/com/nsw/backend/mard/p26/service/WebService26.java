package com.nsw.backend.mard.p26.service;

import com.nsw.backend.mard.p26.client.ResponseWrapper;
import com.nsw.backend.mard.p26.model.TbdHoso26;
import com.nsw.backend.util.ResponseJson;

public interface WebService26 {
    ResponseJson sendHoso26(TbdHoso26 tbdHoso26);

    ResponseJson phanHoiDon(ResponseWrapper request);

    ResponseJson tiepNhanCVMienKiem(ResponseWrapper request);

    ResponseJson thuHoiCVMienKiem(ResponseWrapper request);

}
