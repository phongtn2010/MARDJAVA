package com.nsw.backend.mard.p25.client;


import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class XacNhanDon {


    String fiNSWFileCode;

    String fiSoGXN;

    String fiIdCqxl;

    String fiNameCqxl;
    String fiIdCqcd;

    String fiNameCqcd;

    String fiDvdg;

    Date fiNgayXN;

    String fiNoiXN;

    String fiNguoiXN;

    String fiNSWFileCodeOld;

    String fiAniFeedConfirmOldNo;

    List<TbdHanghoa25> fiProductList;

    String fiGhiChu;
}
