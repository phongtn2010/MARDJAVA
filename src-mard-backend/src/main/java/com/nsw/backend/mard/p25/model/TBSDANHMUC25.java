package com.nsw.backend.mard.p25.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "TBSDANHMUC25")
@Data
public class TBSDANHMUC25 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FIIDCAT", nullable = false)
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
    private String fiCatParent;

    @Column(name = "FI_CAT_TYPE", nullable = false)
    private Long fiCatType;

    @Column(name = "FI_CAT_TYPE_NAME")
    private String fiCatTypeName;

    @Column(name = "FI_ORDER", nullable = false)
    private Long fiOrder;
}
