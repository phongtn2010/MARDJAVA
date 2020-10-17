package com.nsw.mic.p03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
 *
 *
 * @Model
 * @class TbdGiayPhep03
 * Created by Nguyen Van Quang
 * 11/12/2048 10:06:22
 *
 */
@Getter
@Setter
public class TbdGiayPhep03DTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiId;

    @NotNull
    private Long fiIdHoSo;

    @NotNull
    @Size(max = 100)
    private String fiSoGiayPhep;

    @NotNull
    @Size(max = 100)
    private String fiNoiCapGP;

    @NotNull
    private Date fiNgayCapGP;

    @NotNull
    private Date fiNgayDeNghi;

    @NotNull
    private Integer fiTongSoTen;

    @NotNull
    private Integer fiTongSoBan;

    @NotNull
    private Integer fiTongSoBangDia;

    @NotNull
    @Size(max = 255)
    private String fiXuatXu;

    @NotNull
    @Size(max = 255)
    private String fiTenNhaCC;

    @NotNull
    @Size(max = 50)
    private String fiTenCuaKhauNhap;

    @NotNull
    @Size(max = 50)
    private String fiTenNguoiKy;

    @NotNull
    @Size(max = 50)
    private String fiChucDanh;

    @Size(max = 255)
    private String fiLinkGP;

    @Size(max = 500)
    private String fiXuatBanPhamKhongChoPhep;

    @Size(max = 500)
    private String fiXuatBanPhamCanThamDinh;

    private List<TbdGPThietBi03DTO> tbdGPThietBi03DTOS = new ArrayList<>();

    private List<TbdYeuCauSuaGP03DTO> tbdYeuCauSuaGP03DTOS = new ArrayList<>();

}