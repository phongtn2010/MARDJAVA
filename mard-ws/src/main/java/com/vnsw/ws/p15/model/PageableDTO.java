package com.vnsw.ws.p15.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class PageableDTO
* Created by Nguyen Van Quang
* 06/12/2018 11:158:06
*
*/
public class PageableDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public PageableDTO() {}

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

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "PageableDTO [" +
				"size=" + size + "," + 
				"number=" + number + "," + 
				"sort=" + sort + "," + 
				"direction=" + direction + "]";
	}
}