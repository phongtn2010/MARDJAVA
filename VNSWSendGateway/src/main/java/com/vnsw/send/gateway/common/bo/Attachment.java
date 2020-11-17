package com.vnsw.send.gateway.common.bo;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * @author Linhdx
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attachment")
public class Attachment {

	@XmlElement(name = "AttachTypeCode")
	private String AttachTypeCode;
	@XmlElement(name = "AttachTypeName")
	private String AttachTypeName;
	@XmlElement(name = "DocumentNo")
	private String DocumentNo;
	@XmlElement(name = "DocumentDate")
	private String DocumentDate;
	@XmlElement(name = "DocumentDept")
	private String DocumentDept;
	@XmlElement(name = "FileName")
	private String FileName;
	@XmlElement(name = "FileByte")
	private String FileByte;

	public Attachment() {

	}

	public String getAttachTypeCode() {
		return AttachTypeCode;
	}

	public void setAttachTypeCode(String attachTypeCode) {
		AttachTypeCode = attachTypeCode;
	}

	public String getAttachTypeName() {
		return AttachTypeName;
	}

	public void setAttachTypeName(String attachTypeName) {
		AttachTypeName = attachTypeName;
	}

	public String getDocumentNo() {
		return DocumentNo;
	}

	public void setDocumentNo(String documentNo) {
		DocumentNo = documentNo;
	}

	public String getDocumentDate() {
		return DocumentDate;
	}

	public void setDocumentDate(String documentDate) {
		DocumentDate = documentDate;
	}

	public String getDocumentDept() {
		return DocumentDept;
	}

	public void setDocumentDept(String documentDept) {
		DocumentDept = documentDept;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getFileByte() {
		return FileByte;
	}

	public void setFileByte(String fileByte) {
		FileByte = fileByte;
	}
	
	

	
}
