package com.nsw.mard.p19.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class KetQuaXuLy19
* Created by Nguyen Van Quang
* 04/12/2019 09:24:224
*
*/
public class KetQuaXuLy19DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public KetQuaXuLy19DTO() {}

	public KetQuaXuLy19DTO(Long fiId, Long fiIdHoSo, Integer fiStatus, Date fiCreateDate, String fiContent, String fiNameOfRegistration, String fiProcessor, Date fiProcessDate, String fiLink, String fiPath, String fiUuid, String fiStatusName) {
		this.fiId = fiId;
		this.fiIdHoSo = fiIdHoSo;
		this.fiStatus = fiStatus;
		this.fiCreateDate = fiCreateDate;
		this.fiContent = fiContent;
		this.fiNameOfRegistration = fiNameOfRegistration;
		this.fiProcessor = fiProcessor;
		this.fiProcessDate = fiProcessDate;
		this.fiLink = fiLink;
		this.fiPath = fiPath;
		this.fiUuid = fiUuid;
		this.fiStatusName = fiStatusName;
	}

	private Long fiId;

	private Long fiIdHoSo;

	@NotNull
	private Integer fiStatus;

	@NotNull
	// bỏ phần HH:mm:ss trong JsonFormat
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiCreateDate;

	@NotNull
	@Size(max = 2000)
	private String fiContent;

	@Size(max = 250)
	private String fiNameOfRegistration;

	@NotNull
	@Size(max = 250)
	private String fiProcessor;

	@NotNull
	// bỏ định dạng  HH:mm:ss
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiProcessDate;

	@Size(max = 500)
	private String fiLink;

	@Size(max = 250)
	private String fiPath;

	@Size(max = 250)
	private String fiUuid;

	@NotNull
	private String fiStatusName;

	public Long getFiId() {
		return this.fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public Long getFiIdHoSo() {
		return this.fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public Integer getFiStatus() {
		return this.fiStatus;
	}

	public void setFiStatus(Integer fiStatus) {
		this.fiStatus = fiStatus;
	}

	public Date getFiCreateDate() {
		return this.fiCreateDate;
	}

	public void setFiCreateDate(Date fiCreateDate) {
		this.fiCreateDate = fiCreateDate;
	}

	public String getFiContent() {
		return this.fiContent;
	}

	public void setFiContent(String fiContent) {
		this.fiContent = fiContent;
	}

	public String getFiNameOfRegistration() {
		return this.fiNameOfRegistration;
	}

	public void setFiNameOfRegistration(String fiNameOfRegistration) {
		this.fiNameOfRegistration = fiNameOfRegistration;
	}

	public String getFiProcessor() {
		return this.fiProcessor;
	}

	public void setFiProcessor(String fiProcessor) {
		this.fiProcessor = fiProcessor;
	}

	public Date getFiProcessDate() {
		return this.fiProcessDate;
	}

	public void setFiProcessDate(Date fiProcessDate) {
		this.fiProcessDate = fiProcessDate;
	}

	public String getFiLink() {
		return this.fiLink;
	}

	public void setFiLink(String fiLink) {
		this.fiLink = fiLink;
	}

	public String getFiPath() {
		return this.fiPath;
	}

	public void setFiPath(String fiPath) {
		this.fiPath = fiPath;
	}

	public String getFiUuid() {
		return this.fiUuid;
	}

	public void setFiUuid(String fiUuid) {
		this.fiUuid = fiUuid;
	}

	public String getFiStatusName() {
		return this.fiStatusName;
	}

	public void setFiStatusName(String fiStatusName) {
		this.fiStatusName = fiStatusName;
	}

	@Override
	public String toString() {
		return "KetQuaXuLy19 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiStatus=" + fiStatus + "," + 
				"fiCreateDate=" + fiCreateDate + "," + 
				"fiContent=" + fiContent + "," + 
				"fiNameOfRegistration=" + fiNameOfRegistration + "," + 
				"fiProcessor=" + fiProcessor + "," + 
				"fiProcessDate=" + fiProcessDate + "," + 
				"fiLink=" + fiLink + "," + 
				"fiPath=" + fiPath + "," + 
				"fiUuid=" + fiUuid + "," + 
				"fiStatusName=" + fiStatusName + "]";
	}
}
