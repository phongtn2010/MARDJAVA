package com.nsw.backend.mard.p26.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

@Data
public class FilterForm {
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
    @JsonIgnore
    private List<String> fiLstNSWFileCode;


}
