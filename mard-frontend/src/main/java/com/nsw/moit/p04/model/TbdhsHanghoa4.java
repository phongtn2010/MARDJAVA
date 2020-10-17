package com.nsw.moit.p04.model;

import java.util.Date;

public class TbdhsHanghoa4 {

    private Long fiIdHh;
    //@Column(name = "FI_ID_HOSO")
    private Long fiIdHoso;
    //@Size(max = 250)
    //@Column(name = "FI_MAHANG")
    private String fiMahang;
    //@Column(name = "FI_SOLUONG")
    private Long fiSoluong;
    //@Column(name = "FI_HOATDONG")
    private Long fiHoatdong;
    //@Size(max = 50)
    //@Column(name = "FI_NGUOITAO")
    private String fiNguoitao;
    //@Column(name = "FI_NGAYTAO")
    // @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgaytao;
    //@Column(name = "FI_NG_CAPNHAT")
    // @Temporal(TemporalType.TIMESTAMP)
    private Date fiNgCapnhat;

    public TbdhsHanghoa4() {
        super();
    }

    public Long getFiIdHh() {
        return fiIdHh;
    }

    public void setFiIdHh(Long fiIdHh) {
        this.fiIdHh = fiIdHh;
    }

    public Long getFiIdHoso() {
        return fiIdHoso;
    }

    public void setFiIdHoso(Long fiIdHoso) {
        this.fiIdHoso = fiIdHoso;
    }

    public String getFiMahang() {
        return fiMahang;
    }

    public void setFiMahang(String fiMahang) {
        this.fiMahang = fiMahang;
    }

    public Long getFiSoluong() {
        return fiSoluong;
    }

    public void setFiSoluong(Long fiSoluong) {
        this.fiSoluong = fiSoluong;
    }

    public Long getFiHoatdong() {
        return fiHoatdong;
    }

    public void setFiHoatdong(Long fiHoatdong) {
        this.fiHoatdong = fiHoatdong;
    }

    public String getFiNguoitao() {
        return fiNguoitao;
    }

    public void setFiNguoitao(String fiNguoitao) {
        this.fiNguoitao = fiNguoitao;
    }

    public Date getFiNgaytao() {
        return fiNgaytao;
    }

    public void setFiNgaytao(Date fiNgaytao) {
        this.fiNgaytao = fiNgaytao;
    }

    public Date getFiNgCapnhat() {
        return fiNgCapnhat;
    }

    public void setFiNgCapnhat(Date fiNgCapnhat) {
        this.fiNgCapnhat = fiNgCapnhat;
    }

    

}
