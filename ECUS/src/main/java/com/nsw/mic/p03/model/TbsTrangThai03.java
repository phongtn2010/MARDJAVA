package com.nsw.mic.p03.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbsTrangThai03
* Created by Nguyen Van Quang
* 11/12/2048 10:08:45
*
*/
@Getter
@Setter
public class TbsTrangThai03 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private String fiCode;

	private String fiStatusName;

	private String fiDocumentType;

}