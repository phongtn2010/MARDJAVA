package com.nsw.mard.p9.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TdbXnChitieu09 implements Serializable {
    private Long fiIdCT;
    private Long fiIdXND;
    private String fiAnanyticalCode;
    private String fiAnanyticalName;
    private String fiRequired;
}