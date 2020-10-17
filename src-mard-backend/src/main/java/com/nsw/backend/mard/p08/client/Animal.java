package com.nsw.backend.mard.p08.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private long fiAnimalSort;
    private long fiAnimalId;
    private String fiAnimalName;
    private Integer fiAnimalQuantityFemale;
    private Integer fiAnimalQuantityMale;
    private String fiAnimalExporterStateName;
    private String fiAnimalPortOfDestinationName;
}
