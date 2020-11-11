package com.nsw.mard.p26.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TbdHoso26  implements Serializable{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Integer fiIdHoso;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    //Thong tin ho so
    private String fiMaHoso;

    private Integer fiHSType = 1;

    private Integer fiTrangthai;

    private boolean fiActive = true;

    private Date fiNgaytao;

    //Các field phục vụ yêu cầu sửa.
    private String fiReason;

    private String fiRequestDate;

    private Integer fiIdHSParent;

    //Thông tin to chuc, ca nhan
    private String fiTenDn;

    private String fiDiachiDn;

    private String fiSdtDn;

    private String fiFaxDn;

    private String fiEmailDn;

    //Thông tin hồ sơ Doanh Nghiệp
    private String fiSignProvinCode;

    private String fiSignProvinName;

    private String fiNguoiKy;

    private String fiDiadiemKy;

    private Date fiNgayKy;

    private String fiMasothue;

    //Danh sách thông tin kèm theo
    private List<TbdHanghoa26> fiProductList;

}
