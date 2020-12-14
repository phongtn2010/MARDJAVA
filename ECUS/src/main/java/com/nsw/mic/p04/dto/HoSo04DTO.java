package com.nsw.mic.p04.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class HoSo04DTO
* Created by Nguyen Van Quang
* 11/12/2048 09:58:18
*
*/
@lombok.Getter
@lombok.Setter
public class HoSo04DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public HoSo04DTO() {}

	public HoSo04DTO(Long fiIdHoSo, String fiDocumentType, String fiDocumentName, Integer fiStatus, Date fiSendDate,  String fiNameOfRegistration , String fiDispatchNo, String fiSignConfirmName, Date fiSignConfirmDate, String fiStatusName) {
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