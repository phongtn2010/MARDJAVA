package com.nsw.mic.p03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class TbdKetQuaXuLy03
* Created by Nguyen Van Quang
* 04/12/2048 09:036:58
*
*/
@Getter
@Setter
public class TbdKetQuaXuLy03DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	@NotNull
	private Long fiIdHoSo;

	@NotNull
	private Integer fiStatus;

	@NotNull
	private Date fiCreateDate;

	@NotNull
	@Size(max = 2000)
	private String fiContent;

	@NotNull
	private Date fiProcessDate;

	@Size(max = 250)
	private String fiNameOfRegistration;

	@NotNull
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

}