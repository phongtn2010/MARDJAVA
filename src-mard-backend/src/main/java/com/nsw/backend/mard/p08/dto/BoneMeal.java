package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BoneMeal implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiBoneMealId;
    private Integer fiBoneMealSort;

    private String fiBoneMealCode;
    private String fiBoneMealName;
    private Float fiBoneMealQuantity;
    private String fiBoneMealQuantityUnitCode;
    private String fiBoneMealQuantityUnitName;
    private String fiBoneMealExporterStateName;
    private String fiBoneMealExporterStateCode;
    private String fiBoneMealPortOfDestinationName;
    private String fiBoneMealPortOfDestinationCode;
}
