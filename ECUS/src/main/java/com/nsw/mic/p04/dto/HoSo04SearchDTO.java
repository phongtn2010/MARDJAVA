package com.nsw.mic.p04.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class HoSo04SearchDTO
* Created by Nguyen Van Quang
* 05/04/2049 22:19:57
*
*/
@Getter
@Setter
public class HoSo04SearchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Size(max = 255)
	private String fiDocumentType;

	@Size(max = 255)
	private String fiDocumentName;

	private Integer fiStatus;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fiFromCreateDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiToCreateDate;

	private Integer fiActive;

	@Size(max = 14)
	private String fiTaxCode;

	@Size(max = 50)
	private String fiDispatchNo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fiFromSignConfirmDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fiToSignConfirmDate;

	private String fiExcludeTaxCode;

	private int pageIndex = 0;

	private int pageSize = 15;

	@Override
	public String toString() {
		return "HoSo04SearchDTO{" +
				"fiDocumentType='" + fiDocumentType + '\'' +
				", fiDocumentName='" + fiDocumentName + '\'' +
				", fiStatus=" + fiStatus +
				", fiFromCreateDate=" + fiFromCreateDate +
				", fiToCreateDate=" + fiToCreateDate +
				", fiActive=" + fiActive +
				", fiTaxCode='" + fiTaxCode + '\'' +
				", fiDispatchNo='" + fiDispatchNo + '\'' +
				", fiFromSignConfirmDate=" + fiFromSignConfirmDate +
				", fiToSignConfirmDate=" + fiToSignConfirmDate +
				", fiExcludeTaxCode='" + fiExcludeTaxCode + '\'' +
				", pageIndex=" + pageIndex +
				", pageSize=" + pageSize +
				'}';
	}
}