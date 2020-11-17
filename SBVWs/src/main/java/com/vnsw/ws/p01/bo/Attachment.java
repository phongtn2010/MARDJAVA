package com.vnsw.ws.p01.bo;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * @author Linhdx
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attachment")
public class Attachment {

	@XmlElement(name = "AttachTypeCode")
	private String attachTypeCode;
	@XmlElement(name = "AttachTypeName")
	private String attachTypeName;
	@XmlTransient
	private String documentNo;
	@XmlTransient
	private String documentDate;
	@XmlTransient
	private String documentDept;
	@XmlElement(name = "FileName")
	private String fileName;
	@XmlElement(name = "FileByte")
	private String fileByte;

	public String getAttachTypeCode() {
		return attachTypeCode;
	}

	public void setAttachTypeCode(String attachTypeCode) {
		this.attachTypeCode = attachTypeCode;
	}

	public String getAttachTypeName() {
		return attachTypeName;
	}

	public void setAttachTypeName(String attachTypeName) {
		this.attachTypeName = attachTypeName;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	public String getDocumentDept() {
		return documentDept;
	}

	public void setDocumentDept(String documentDept) {
		this.documentDept = documentDept;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileByte() {
		return fileByte;
	}

	public void setFileByte(String fileByte) {
		this.fileByte = fileByte;
	}
	
	

	
}
