/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p26.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FilterForm implements Serializable {

    private String maHoSo;
    private Long loaiHoSo;
    private String soCongVan;
    private Integer trangThaiHoSo;
    private Date ngayTaoTuNgay;
    private Date ngayTaoDenNgay;
    private Date ngayCapTuNgay;
    private Date ngayCapDenNgay;
    private String nguoiTao;
    private String tenDoanhNghiep;
    private String tenHangHoa;
    private String maSoThue;
    private boolean hoatDong=true;
    private Integer page = 1;
    private Integer size = 20;
    private String sortBy = "fiMaHoso";
    private String order = "asc";
    private Integer fiHSType;
}
