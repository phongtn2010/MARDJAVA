package com.nsw.sbv.p02.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class TbdHanghoa2 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOA2_SEQ";

    private Integer fiIdHangHoa;

    private Integer fiIdHS;

    private Integer fiIdDanhMucVang;

    private Integer fiHamLuong;

    private Float fiKhoiLuong;

    private Integer fiIdDonViTinh;

    private Float fiGiaTriUocTinh;
}
