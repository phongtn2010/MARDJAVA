package com.nsw.mard.p7.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbdHanghoa07 extends CmonHangHoa07 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOA07_SEQ";

    private Integer fiIdProduct;

    private Integer fiIdHS;
}

