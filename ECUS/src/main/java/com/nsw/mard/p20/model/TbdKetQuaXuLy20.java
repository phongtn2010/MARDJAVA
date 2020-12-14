package com.nsw.mard.p20.model;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdKetQuaXuLy20
* Created by Nguyen Van Quang
* 11/12/2020 10:08:11
*
*/
public class TbdKetQuaXuLy20 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private Integer fiStatus;

	private Date fiCreateDate;

	private String fiContent;

	private Date fiProcessDate;

	private String fiNameOfRegistration;

	private String fiProcessor;

	private String fiLink;

	private String fiFileName;

	private String fiPath;

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

	@Size(max = 255)
	private String fiDocumentType;

	@Size(max = 255)
	private String fiDocumentName;

	public String getFiDocumentType() {
		return fiDocumentType;
	}

	public void setFiDocumentType(String fiDocumentType) {
		this.fiDocumentType = fiDocumentType;
	}

	public String getFiDocumentName() {
		return fiDocumentName;
	}

	public void setFiDocumentName(String fiDocumentName) {
		this.fiDocumentName = fiDocumentName;
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
