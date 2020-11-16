package com.nsw.backend.dic.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TBSDANHMUCVANG2", schema = "SBV")
// Define named queries here
@NamedQueries({
        @NamedQuery(name = "CmonVang.countAll", query = "SELECT COUNT(x) FROM CmonVang x")
})
public class CmonVang extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBSDANHMUCVANG2_SEQ";

    @Id
    @Column(name = "FI_ID_DANHMUCVANG")
    private Integer fiIdDanhMucVang;

    @Column(name = "FI_TEN_DANHMUCVANG", length = 255)
    private String fiMaCuaKhau;

    public CmonVang() {
        super();
    }

}
