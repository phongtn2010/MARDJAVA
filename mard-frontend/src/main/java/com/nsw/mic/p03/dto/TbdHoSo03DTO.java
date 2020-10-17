package com.nsw.mic.p03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class TbdHoSo03
* Created by Nguyen Van Quang
* 04/12/2048 10:034:57
*
*/
@Getter
@Setter
public class TbdHoSo03DTO implements Serializable {

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

	@Size(max = 100)
	private String fiChucDanh;

	@NotNull
	@Size(max = 100)
	private String fiDiaDiemKy;

	@NotNull
	private Integer fiTongSoXBPham;

	@NotNull
	private Integer fiTongSoBangDia;

	@Size(max = 2000)
	private String fiXuatXu;

	@Size(max = 2000)
	private String fiTenNhaCC;

	@Size(max = 2000)
	private String fiCuaKhauNhap;

	private String fiStatusName;

	private Integer fiSended;

	private List<TbdThietBi03DTO> tbdThietBi03DTOS = Collections.emptyList();

	private List<TbdDinhKem03DTO> tbdDinhKem03DTOS = Collections.emptyList();

	private List<TbdGiayPhep03DTO> tbdGiayPhep03DTOS = Collections.emptyList();

	private Integer fiTongSoTenXBP;

}
