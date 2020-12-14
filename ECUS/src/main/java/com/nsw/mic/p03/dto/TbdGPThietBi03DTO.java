package com.nsw.mic.p03.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TbdGPThietBi03DTO {

  private Long fiId;

  private Long fiIdGiayPhep;

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
  private Long fiSoBan;

  @NotNull
  @Size(max = 1000)
  private String fiTomTat;

  @NotNull
  private Long fiSoLuongDia;

  @NotNull
  private Long fiSoLuongBang;

  @NotNull
  private Long fiSoLuongCatset;

  @NotNull
  @Size(max = 255)
  private String fiPhamViSuDung;

  @NotNull
  @Size(max = 255)
  private String fiHinhThucKhac;

  @NotNull
  private Integer fiStatusDispatchNo;


}
