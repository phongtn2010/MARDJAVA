package com.nsw.mic.p04.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
 *
 *
 * @Entity
 * @class TbdNguoiThamDinh04
 * Created by Nguyen Van Quang
 * 05/04/2049 23:40:16
 *
 */
@Getter
@Setter
public class TbdNguoiThamDinh04DTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiId;

    private Long fiIdHoSo;

    @NotNull
    @Size(max = 255)
    private String fiHoTen;

    @NotNull
    private Date fiNgaySinh;

    @NotNull
    @Size(max = 255)
    private String fiTrinhDoNghiepVu;

    @NotNull
    @Size(max = 255)
    private String fiTrinhDoChuyenMon;

    @NotNull
    @Size(max = 255)
    private String fiTrinhDoNgoaiNgu;

    @NotNull
    @Size(max = 1000)
    private String fiThamNienCongTac;

    @Override
    public String toString() {
        return "TbdNguoiThamDinh04DTO{" +
                "fiId=" + fiId +
                ", fiIdHoSo=" + fiIdHoSo +
                ", fiHoTen='" + fiHoTen + '\'' +
                ", fiNgaySinh=" + fiNgaySinh +
                ", fiTrinhDoNghiepVu='" + fiTrinhDoNghiepVu + '\'' +
                ", fiTrinhDoChuyenMon='" + fiTrinhDoChuyenMon + '\'' +
                ", fiTrinhDoNgoaiNgu='" + fiTrinhDoNgoaiNgu + '\'' +
                ", fiThamNienCongTac='" + fiThamNienCongTac + '\'' +
                '}';
    }
}
