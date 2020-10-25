package com.nsw.backend.mard.p25.dto;


import lombok.Data;
import java.io.Serializable;
import java.util.Date;


@Data
public class TbdattachDg25 implements Serializable {

    private String fiSoPhieu;

    private Date fiNgayPhieu;
    private String fiFileId;
    private String fiFileName;
    private String fiFileLink;

}
