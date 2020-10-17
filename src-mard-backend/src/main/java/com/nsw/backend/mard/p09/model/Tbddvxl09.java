package com.nsw.backend.mard.p09.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "TBDDVXL09", schema = "MARD")
@NamedQueries({
        @NamedQuery(name = "Tbddvxl09.countAll", query = "SELECT COUNT(x) FROM Tbddvxl09 x")
})
public class Tbddvxl09 implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_PU", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDDVXL09_SEQ")
    @SequenceGenerator(sequenceName = "TBDDVXL09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDDVXL09_SEQ")
    private Long fiIdPU;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "FI_PU_CODE")
    private String fiPUCode;

    @Column(name = "FI_PU_DESC")
    private String fiPUDesc;

    @Column(name = "FI_PU_LEVEL")
    private int fiPULevel;

    @Column(name = "FI_PARENT_PU")
    private Long fiPUParentID;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FI_PARENT_PU")
    private List<Tbddvxl09> lstChildPU;

    public Tbddvxl09() {
        lstChildPU = new ArrayList<>();
    }

}