package com.nsw.mic.p04.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TbdGiayPhep04DTO {

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
    @Size(max = 255)
    private String fiTenTCCaNhan;

    @NotNull
    @Size(max = 500)
    private String fiDiaChi;

    @NotNull
    @Size(max = 50)
    private String fiSoDienThoai;

    @Size(max = 50)
    private String fiFax;

    @NotNull
    @Size(max = 50)
    private String fiEmail;

    @Size(max = 50)
    private String fiWebsite;

    @NotNull
    @Size(max = 50)
    private String fiTenNguoiKy;

    @NotNull
    @Size(max = 50)
    private String fiChucDanh;

    @Size(max = 255)
    private String fiLinkGP;

    private List<TbdYeuCauSuaGP04DTO> tbdYeuCauSuaGP04DTOS = new ArrayList<>();


}
