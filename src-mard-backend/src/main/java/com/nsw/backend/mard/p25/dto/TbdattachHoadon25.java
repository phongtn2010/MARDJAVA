package com.nsw.backend.mard.p25.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbdattachHoadon25 implements Serializable {

    private String fiSoHoadon;

    private Date fiNgayHoadon;

    private String fiFileId;

    private String fiFileName;

    private String fiFileLink;

}
