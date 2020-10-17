package com.nsw.mic.p03.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class TbdThietBi03DTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiId;

    private Long fiIdHoSo;

    @NotNull
    @Size(max = 255)
    private String fiMaISBN;

    @NotNull
    @Size(max = 255)
    private String fiTenGoc;

    @NotNull
    @Size(max = 255)
    private String fiTenTiengViet;

    @NotNull
    @Size(max = 255)
    private String fiTenTacGia;

    @NotNull
    @Size(max = 255)
    private String fiTenNhaCC;

    @NotNull
    @Size(max = 255)
    private String fiTheLoai;

    @NotNull
    private Long fiSoBan = 0L;

    @NotNull
    @Size(max = 1000)
    private String fiTomTat;

    @NotNull
    private Long fiSoLuongDia = 0L;

    @NotNull
    private Long fiSoLuongBang = 0L;

    @NotNull
    private Long fiSoLuongCatset = 0L;

    @NotNull
    @Size(max = 255)
    private String fiPhamViSuDung;

    @NotNull
    @Size(max = 255)
    private String fiHinhThucKhac;


}
