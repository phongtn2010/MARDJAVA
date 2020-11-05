package com.nsw.mard.p25.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class TbdHangHoaFile25 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOA_FILE25_SEQ";
    private Integer fiId;

    private String fiFileId;
    private String fiFileLink;
    private String fiFileName;
    private Integer fiIDHangHoa;
    private Integer fiLoaiFile;
    private String fiTenLoai;
    private String fiTenFile;
    private String fiSoCV;
    private Date fiNgayCap;
}
