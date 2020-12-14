package com.nsw.mic.p03.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/***
*
*
* @Model
* @class TbsTepDinhKem03
* Created by Nguyen Van Quang
* 11/12/2048 10:08:032
*
*/
@Getter
@Setter
public class TbsTepDinhKem03 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tepDinhKemId;

	private String tenTep;

	private String loaiTep;

	private String loaiThuTuc;

	private Boolean required;

	private Integer order;

	private Integer maLoaiTep;

}