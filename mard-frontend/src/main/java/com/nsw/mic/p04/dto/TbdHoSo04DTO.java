package com.nsw.mic.p04.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/***
 *
 *
 * @Entity
 * @class TbdHoSo04
 * Created by Nguyen Van Quang
 * 05/04/2049 22:52:41
 *
 */
@Getter
@Setter
public class TbdHoSo04DTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiIdHoSo;

    @NotNull
    @Size(max = 255)
    private String fiDocumentType;

    @Size(max = 255)
    private String fiDocumentName;

    @NotNull
    private Integer fiStatus;

    private Integer fiOldStatus;

    private Integer fiVersion;

    @NotNull

    private Date fiCreateDate;

    @NotNull

    private Date fiModifiedDate;


    private Date fiSendDate;


    private Date fiReceiveDate;

    @NotNull
    private Integer fiActive;

    @Size(max = 500)
    private String fiReasonDrawal;

    @Size(max = 500)
    private String fiReasonCorrection;

    @NotNull
    @Size(max = 14)
    private String fiTaxCode;

    private String fiStatusName;

    private Integer fiSended;

    @NotNull
    @Size(max = 255)
    private String fiSoDonDeNghi;

    @NotNull
    @Size(max = 50)
    private String fiNoiDNCapPhep;

    @NotNull
    @Size(max = 50)
    private String fiTenTCCaNhan;

    @Size(max = 255)
    private String fiTenCQChuQuan;

    @NotNull
    @Size(max = 500)
    private String fiDiaChi;

    @NotNull
    @Size(max = 50)
    private String fiSoDienThoai;

    @NotNull
    @Size(max = 255)
    private String fiTenNguoiKy;

    @Size(max = 50)
    private String fiFax;

    @NotNull
    @Size(max = 50)
    private String fiEmail;

    @Size(max = 50)
    private String fiWebsite;

    @Size(max = 100)
    private String fiChucDanh;

    @Size(max = 2000)
    private String fiTenNhaCC;

    @NotNull
    private Integer fiNhapKhauSach;

    private List<TbdNguoiThamDinh04DTO> tbdNguoiThamDinh04DTOS;

    private List<TbdDinhKem04DTO> tbdDinhKem04DTOS;

    private List<TbdGiayPhep04DTO> tbdGiayPhep04DTOS;


}