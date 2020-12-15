/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tbddongvat08 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdAnimal;

    private Long fiIdHS;

    private String fiAnimalName;

    private int fiQtyMale= 0;

    private int fiQtyFemale = 0;

    private String fiUnitCode; //Unit of measurement

    private String fiCountryOrigin;

    private String fiPortName;
}