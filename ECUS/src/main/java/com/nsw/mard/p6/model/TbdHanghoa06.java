package com.nsw.mard.p6.model;
import lombok.Data;


import java.io.Serializable;

@Data
public class TbdHanghoa06 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDHANGHOA06_SEQ";

    private Long fiIdProduct;

    private Long fiIdHS;

    private Long fiProductType;

    private String fiProductBusinessName;

    private String fiProductScienceName;

    private String fiPackageUnitCode;

    private String fiPackageUnitName;

    private String fiOriginCountryCode;

    private String fiOriginCountryName;

    private Double fiQuantity;

    private String fiSizeOrType;

}

