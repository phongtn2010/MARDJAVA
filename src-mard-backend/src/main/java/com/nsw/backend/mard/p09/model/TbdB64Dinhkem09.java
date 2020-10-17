package com.nsw.backend.mard.p09.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBDB64DINHKEM09", schema = "MARD")
@Data
public class TbdB64Dinhkem09 extends CmonBaseEntity implements Serializable {
    private static final String SEQUENCE_NAME = "TBDB64DINHKEM09_SEQ";
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FIID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 10000, allocationSize = 1, name = SEQUENCE_NAME)
    private Long fiId;

    @Column(name = "FIUUID")
    private String fiUuid;

    @Column(name = "FICONTENT")
    @Lob
    private String fiContent;

    @Column(name = "FIFILENAME")
    private String fiFileName;

    @Column(name = "FITAXCODE")
    private String fiTaxCode;

    @Column(name = "FIPARENTTABLE")
    private String fiParentTable;
}
