package com.nsw.backend.mard.p01.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "\"Cmon_SeafoodProcessors\"", schema = "MARD")
public class Cmon_SeafoodProcessors {
    public static final String SEQUENCE_NAME = "CMON_SEAFOODPROCESSORS_MA";

    @Id
    @Column(name = "\"SeafoodProcessorsId\"", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiId;

    @Column(name = "\"SeafoodProcessorsCode\"")
    private String fiCode;

    @Column(name = "\"SeafoodProcessorsName\"")
    private String fiVNName;

    @Column(name = "\"SeafoodProcessorsAdress\"")
    private String fiVNAdd;

    @Column(name = "\"CommercialNameOfEstablishments\"")
    private String fiENName;
    @Column(name = "\"SeafoodProcessorsAdressEn\"")
    private String fiENAdd;
}
