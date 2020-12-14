package com.nsw.mic.p03.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class PageableDTO
* Created by Nguyen Van Quang
* 11/12/2048 10:0303:50
*
*/
@Getter
@Setter
public class PageableDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public PageableDTO() {}

	public PageableDTO(Integer size, Integer number) {
		this.size = size;
		this.number = number;
	}

	public PageableDTO(Integer size, Integer number, String sort, String direction) {
		this.size = size;
		this.number = number;
		this.sort = sort;
		this.direction = direction;
	}

	@Min(value = 1)
	private Integer size = 15;

	@Min(value = 0)
	private Integer number = 0;

	@Size(max = 50)
	private String sort;

	@Size(max = 4)
	private String direction = "desc";

}