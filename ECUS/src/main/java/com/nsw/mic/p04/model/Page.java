package com.nsw.mic.p04.model;

/***
*
*
* @class Page
* Created by Nguyen Van Quang
* 11/12/2048 10:33:50
*
*/
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Page <T> {

	private List<T> content;
	private long totalElements;
	private boolean last;
	private long totalPages;
	private int size;
	private long number;
	private boolean first;
	private long numberOfElements;

}