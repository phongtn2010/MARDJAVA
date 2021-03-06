package com.vnsw.ws.p14.message;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/***
*
*
* @Model
* @class Attachment
* Created by Nguyen Van Quang
* 05/12/2018 17:149:45
*
*/
@XmlRootElement(name = "Attachment")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiFileCode", "fiFileName", "fiFileByte"})
public class Attachment {

	public Attachment() {}

	@XmlElement(name = "FileCode", required = true)
	private String fiFileCode;

	@XmlElement(name = "FileName", required = true)
	private String fiFileName;

	@XmlElement(name = "FileByte", required = true)
	private String fiFileByte;

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

	@Override
	public String toString() {
		return "Attachment [" +
				"fiFileCode=" + fiFileCode + "," + 
				"fiFileName=" + fiFileName + "," + 
				"fiFileByte=" + fiFileByte + "]";
	}
}