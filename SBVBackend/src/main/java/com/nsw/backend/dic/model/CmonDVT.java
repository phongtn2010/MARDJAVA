package com.nsw.backend.dic.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "TBSDONVITINH2", schema = "SBV")
// Define named queries here
@NamedQueries({
        @NamedQuery(name = "CmonDVT.countAll", query = "SELECT COUNT(x) FROM CmonDVT x")
})
public class CmonDVT extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "FI_ID_DON_VI_TINH")
    private Integer fiIdDonViTinh;

    @Column(name = "FI_DON_VI_TINH", length = 255)
    private String fiDonViTinh;

    public CmonDVT() {
        super();
    }

}