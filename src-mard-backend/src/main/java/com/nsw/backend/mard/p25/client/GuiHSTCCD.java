package com.nsw.backend.mard.p25.client;

import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import lombok.Data;

import java.util.List;


@Data
public class GuiHSTCCD {
    String fiNSWFileCode;
    String fiIdDVXL;
    String fiNameDVXL;
    List<TbdHanghoa25> fiProductList;
}
