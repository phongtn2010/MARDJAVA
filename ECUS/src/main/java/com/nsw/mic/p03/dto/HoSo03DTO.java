package com.nsw.mic.p03.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class HoSo03DTO
* Created by Nguyen Van Quang
* 11/12/2048 09:58:20
*
*/
@Getter
@Setter
public class HoSo03DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public HoSo03DTO() {}

	public HoSo03DTO(Long fiIdHoSo, String fiDocumentType, String fiDocumentName, Integer fiStatus, Date fiSendDate,  String fiNameOfRegistration , String fiDispatchNo, String fiSignConfirmName, Date fiSignConfirmDate, String fiStatusName) {
		this.fiIdHoSo = fiIdHoSo;
		this.fiDocumentType = fiDocumentType;
		this.fiDocumentName = fiDocumentName;
		this.fiStatus = fiStatus;
		this.fiSendDate = fiSendDate;
		this.fiNameOfRegistration = fiNameOfRegistration;
		this.fiDispatchNo = fiDispatchNo;
		this.fiSignConfirmName = fiSignConfirmName;
		this.fiSignConfirmDate = fiSignConfirmDate;
		this.fiStatusName = fiStatusName;
	}

	private Long fiIdHoSo;

	@NotNull
	@Size(max = 255)
	private String fiDocumentType;

	@NotNull
	@Size(max = 255)
	private String fiDocumentName;

	@NotNull
	private Integer fiStatus;

	private Date fiSendDate;

	@NotNull
	@Size(max = 255)
	private String fiNameOfRegistration;

	@NotNull
	@Size(max = 50)
	private String fiDispatchNo;

	@Size(max = 100)
	private String fiSignConfirmName;

	@NotNull
	private Date fiSignConfirmDate;

	@NotNull
	private String fiStatusName;

}