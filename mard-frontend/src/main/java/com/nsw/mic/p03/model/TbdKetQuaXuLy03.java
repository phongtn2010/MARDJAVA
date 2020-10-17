package com.nsw.mic.p03.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdKetQuaXuLy03
* Created by Nguyen Van Quang
* 11/12/2048 10:07:11
*
*/
@Getter
@Setter
public class TbdKetQuaXuLy03 implements Serializable {

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

	@Size(max = 255)
	private String fiDocumentType;

	@Size(max = 255)
	private String fiDocumentName;

}