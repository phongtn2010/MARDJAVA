package com.nsw.backend.dic.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TBSDANHMUCCUAKHAU2", schema = "SBV")
// Define named queries here
@NamedQueries({
        @NamedQuery(name = "CmonPort.countAll", query = "SELECT COUNT(x) FROM CmonPort x")
})
public class CmonPort extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBSDANHMUCCUAKHAU2_SEQ";

    @Id
    @Column(name = "FI_ID_CUA_KHAU")
    private Integer fiIdCuaKhau;

    @Column(name = "FI_MA_CUA_KHAU", length = 20)
    private String fiMaCuaKhau;


    @Column(name = "FI_TEN_CUA_KHAU", length = 255)
    private String fiTenCuaKhau;

    public CmonPort() {
        super();
    }

}
