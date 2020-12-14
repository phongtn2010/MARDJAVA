package com.nsw.mic.p03.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbsTinhThanhPho03
* Created by Nguyen Van Quang
* 21/12/2048 08:55:19
*
*/
@Getter
@Setter
public class TbsTinhThanhPho03 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private String fiCode;

	private String fiName;

}