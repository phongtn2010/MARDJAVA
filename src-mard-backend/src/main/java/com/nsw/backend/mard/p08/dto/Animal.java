package com.nsw.backend.mard.p08.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdAnimal;
    private Integer fiAnimalSort;

    private String fiAnimalCode;
    private String fiAnimalName;
    private Integer fiAnimalQuantityFemale;
    private Integer fiAnimalQuantityMale;
    private String fiAnimalExporterStateCode;
    private String fiAnimalExporterStateName;
    private String fiAnimalPortOfDestinationCode;
    private String fiAnimalPortOfDestinationName;
}
