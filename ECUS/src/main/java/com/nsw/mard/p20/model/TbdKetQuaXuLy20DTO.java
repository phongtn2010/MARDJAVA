package com.nsw.mard.p20.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class TbdKetQuaXuLy20
* Created by Nguyen Van Quang
* 04/12/2020 09:246:58
*
*/
public class TbdKetQuaXuLy20DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public TbdKetQuaXuLy20DTO() {}

	public TbdKetQuaXuLy20DTO(Long fiId, Long fiIdHoSo, Integer fiStatus, Date fiCreateDate, String fiContent, Date fiProcessDate, String fiNameOfRegistration, String fiProcessor, String fiLink, String fiFileName, String fiPath, String fiUuid) {
		this.fiId = fiId;
		this.fiIdHoSo = fiIdHoSo;
		this.fiStatus = fiStatus;
		this.fiCreateDate = fiCreateDate;
		this.fiContent = fiContent;
		this.fiProcessDate = fiProcessDate;
		this.fiNameOfRegistration = fiNameOfRegistration;
		this.fiProcessor = fiProcessor;
		this.fiLink = fiLink;
		this.fiFileName = fiFileName;
		this.fiPath = fiPath;
		this.fiUuid = fiUuid;
	}

	private Long fiId;


	private Long fiIdHoSo;


	private Integer fiStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiCreateDate;


	@Size(max = 2000)
	private String fiContent;


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiProcessDate;

	@Size(max = 250)
	private String fiNameOfRegistration;


	@Size(max = 250)
	private String fiProcessor;

	@Size(max = 500)
	private String fiLink;

	@Size(max = 250)
	private String fiFileName;

	@Size(max = 250)
	private String fiPath;

	@Size(max = 250)
	private String fiUuid;

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

	public Date getFiProcessDate() {
		return this.fiProcessDate;
	}

	public void setFiProcessDate(Date fiProcessDate) {
		this.fiProcessDate = fiProcessDate;
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

	public String getFiLink() {
		return this.fiLink;
	}

	public void setFiLink(String fiLink) {
		this.fiLink = fiLink;
	}

	public String getFiFileName() {
		return this.fiFileName;
	}

	public void setFiFileName(String fiFileName) {
		this.fiFileName = fiFileName;
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

	@Override
	public String toString() {
		return "TbdKetQuaXuLy20 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiStatus=" + fiStatus + "," + 
				"fiCreateDate=" + fiCreateDate + "," + 
				"fiContent=" + fiContent + "," + 
				"fiProcessDate=" + fiProcessDate + "," + 
				"fiNameOfRegistration=" + fiNameOfRegistration + "," + 
				"fiProcessor=" + fiProcessor + "," + 
				"fiLink=" + fiLink + "," + 
				"fiFileName=" + fiFileName + "," + 
				"fiPath=" + fiPath + "," + 
				"fiUuid=" + fiUuid + "]";
	}
}
