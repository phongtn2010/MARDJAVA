package com.nsw.mic.p04.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class KetQuaXuLy04
* Created by Nguyen Van Quang
* 04/12/2048 09:04:204
*
*/
@Getter
@Setter
public class KetQuaXuLy04DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public KetQuaXuLy04DTO() {}

	public KetQuaXuLy04DTO(Long fiId, Long fiIdHoSo, Integer fiStatus, Date fiCreateDate, String fiContent, String fiNameOfRegistration, String fiProcessor, Date fiProcessDate, String fiLink, String fiPath, String fiUuid, String fiStatusName) {
		this.fiId = fiId;
		this.fiIdHoSo = fiIdHoSo;
		this.fiStatus = fiStatus;
		this.fiCreateDate = fiCreateDate;
		this.fiContent = fiContent;
		this.fiNameOfRegistration = fiNameOfRegistration;
		this.fiProcessor = fiProcessor;
		this.fiProcessDate = fiProcessDate;
		this.fiLink = fiLink;
		this.fiPath = fiPath;
		this.fiUuid = fiUuid;
		this.fiStatusName = fiStatusName;
	}

	private Long fiId;

	private Long fiIdHoSo;

	@NotNull
	private Integer fiStatus;

	@NotNull
	private Date fiCreateDate;

	@NotNull
	@Size(max = 2000)
	private String fiContent;

	@Size(max = 250)
	private String fiNameOfRegistration;

	@NotNull
	@Size(max = 250)
	private String fiProcessor;

	@NotNull
	private Date fiProcessDate;

	@Size(max = 500)
	private String fiLink;

	@Size(max = 250)
	private String fiPath;

	@Size(max = 250)
	private String fiUuid;

	@NotNull
	private String fiStatusName;


}