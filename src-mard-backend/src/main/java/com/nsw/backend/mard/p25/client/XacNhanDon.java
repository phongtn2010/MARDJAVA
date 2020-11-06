package com.nsw.backend.mard.p25.client;


import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class XacNhanDon {


    String fiNSWFileCode;

    String fiAniFeedConfirmNo;

    String DepartmentCode;

    String DepartmentName;
    String fiAssignID;

    String fiAssignName;

    String fiAssignNameOther;

    Date fiSignConfirmDate;

    String fiSignConfirmPlace;

    String fiSignName;

    String fiNSWFileCodeOld;

    String fiAniFeedConfirmOldNo;

    List<TbdHanghoa25> fiProductList;

    String fiNoteGoods;
}
