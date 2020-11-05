package com.nsw.backend.mard.p26.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TBSDANHMUC26")
@Data
public class TBSDANHMUC26 implements Serializable {
    public static final String SEQUENCE_NAME = "TBSDANHMUC26_SEQ";

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(sequenceName = SEQUENCE_NAME, schema = "MARD", initialValue = 1, allocationSize = 1, name = SEQUENCE_NAME)
    private Long FIIDCAT;

    @Column(name = "FI_CREATED_BY")
    private String fiCreatedBy;

    @Column(name = "FI_CREATED_DATE")
    private Date fiCreatedDate;

    @Column(name = "FI_UPDATED_BY")
    private String fiUpdatedBy;

    @Column(name = "FI_UPDATED_DATE")
    private Date fiUpdatedDate;

    @Column(name = "FI_CAT_NAME", nullable = false)
    private String fiCatName;

    @Column(name = "FI_CAT_NO", nullable = false)
    private Long fiCatNo;

    @Column(name = "FI_CAT_NOTE")
    private String fiCatNote;

    @Column(name = "FI_CAT_PARENT")
    private Long fiCatParent;

    @Column(name = "FI_CAT_TYPE", nullable = false)
    private Long fiCatType;

    @Column(name = "FI_CAT_TYPE_NAME")
    private String fiCatTypeName;

    @Column(name = "FI_ORDER", nullable = false)
    private Long fiOrder;
}
