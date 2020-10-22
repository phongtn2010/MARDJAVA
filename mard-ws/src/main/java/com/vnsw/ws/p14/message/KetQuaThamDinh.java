package com.vnsw.ws.p14.message;

import com.vnsw.ws.annotations.DateSerialization;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/***
*
*
* @Model
* @class KetQuaXuLy
* Created by Nguyen Van Quang
* 05/12/2018 17:414:10
*
*/
@XmlRootElement(name = "MedicinePPResult")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiContent", "fiResultDate", "fiDepartment", "fiCreaterName"})
public class KetQuaThamDinh {

	public KetQuaThamDinh() {}

	@XmlElement(name = "Content", required = true)
	private String fiContent;

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "ResultDate", required = true)
	private Date fiResultDate;

	@XmlElement(name = "Department")
	private String fiDepartment;

	@XmlElement(name = "CreaterName")
	private String fiCreaterName;

	public String getFiContent() {
		return this.fiContent;
	}

	public void setFiContent(String fiContent) {
		this.fiContent = fiContent;
	}

	public Date getFiResultDate() {
		return this.fiResultDate;
	}

	public void setFiResultDate(Date fiResultDate) {
		this.fiResultDate = fiResultDate;
	}

	public String getFiDepartment() {
		return this.fiDepartment;
	}

	public void setFiDepartment(String fiDepartment) {
		this.fiDepartment = fiDepartment;
	}

	public String getFiCreaterName() {
		return this.fiCreaterName;
	}

	public void setFiCreaterName(String fiCreaterName) {
		this.fiCreaterName = fiCreaterName;
	}

	@Override
	public String toString() {
		return "KetQuaXuLy [" +
				"fiContent=" + fiContent + "," + 
				"fiResultDate=" + fiResultDate + "," + 
				"fiDepartment=" + fiDepartment + "," + 
				"fiCreaterName=" + fiCreaterName + "]";
	}
}