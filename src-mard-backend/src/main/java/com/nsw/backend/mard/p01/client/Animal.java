package com.nsw.backend.mard.p01.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fiID;
    private String fiAnimalTypeVni;
    private String fiAnimalType;
    private String fiOfficialMark;
    private String fiBreedVni;
    private String fiBreed;
    private String fiAge;
    private Integer fiSex;
}
