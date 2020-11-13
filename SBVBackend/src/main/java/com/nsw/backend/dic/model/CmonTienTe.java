package com.nsw.backend.dic.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TBSDANHMUCTIENTE2", schema = "SBV")
// Define named queries here
@NamedQueries({
        @NamedQuery(name = "CmonTienTe.countAll", query = "SELECT COUNT(x) FROM CmonTienTe x")
})
public class CmonTienTe extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FI_ID_TIEN_TE")
    private Integer fiIdTienTe;

    @Column(name = "FI_KY_HIEU_TIEN", length = 20)
    private String fiKyHieuTien;

    @Column(name = "FI_LOAI_TIEN", length = 255)
    private String fiLoaiTien;

    public CmonTienTe() {
        super();
    }

}