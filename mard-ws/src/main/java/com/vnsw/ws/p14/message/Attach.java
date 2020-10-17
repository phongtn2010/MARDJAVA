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
* @class Attach
* Created by Nguyen Van Quang
* 05/12/2018 17:54:40
*
*/
@XmlRootElement(name = "Attach")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiFileName", "fiFileByte"})
public class Attach {

	public Attach() {}

	@XmlElement(name = "FileName", required = true)
	private String fiFileName;

	@XmlElement(name = "FileByte", required = true)
	private String fiFileByte;

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
		return "Attach [" +
				"fiFileName=" + fiFileName + "," + 
				"fiFileByte=" + fiFileByte + "]";
	}
}