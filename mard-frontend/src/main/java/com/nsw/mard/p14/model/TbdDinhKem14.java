package com.nsw.mard.p14.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/***
*
*
* @Model
* @class TbdDinhKem14
* Created by Nguyen Van Quang
* 11/12/2018 10:05:02
*
*/
public class TbdDinhKem14 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private String fiPath;

	private String fiUuid;

	private Long fiSize;

	private String fiFileCode;

	private String fiFileName;

	private String fiFileByte;

	private String fiFileTypeCode;

	private String fiFileGroup;

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

	public Long getFiSize() {
		return this.fiSize;
	}

	public void setFiSize(Long fiSize) {
		this.fiSize = fiSize;
	}

	public String getFiFileCode() {
		return this.fiFileCode;
	}

	public void setFiFileCode(String fiFileCode) {
		this.fiFileCode = fiFileCode;
	}

	public String getFiFileName() {
		return this.fiFileName;
	}

	public void setFiFileName(String fiFileName) {
		this.fiFileName = fiFileName;
	}

	public String getFiFileByte() {
		return this.fiFileByte;
	}

	public void setFiFileByte(String fiFileByte) {
		this.fiFileByte = fiFileByte;
	}

	public String getFiFileTypeCode() {
		return fiFileTypeCode;
	}

	public void setFiFileTypeCode(String fiFileTypeCode) {
		this.fiFileTypeCode = fiFileTypeCode;
	}

	public String getFiFileGroup() {
		return fiFileGroup;
	}

	public void setFiFileGroup(String fiFileGroup) {
		this.fiFileGroup = fiFileGroup;
	}

	@Override
	public String toString() {
		return "TbdDinhKem14{" +
				"fiId=" + fiId +
				", fiIdHoSo=" + fiIdHoSo +
				", fiPath='" + fiPath + '\'' +
				", fiUuid='" + fiUuid + '\'' +
				", fiSize=" + fiSize +
				", fiFileCode='" + fiFileCode + '\'' +
				", fiFileName='" + fiFileName + '\'' +
				", fiFileByte='" + fiFileByte + '\'' +
				", fiFileTypeCode='" + fiFileTypeCode + '\'' +
				", fiFileGroup='" + fiFileGroup + '\'' +
				'}';
	}
}