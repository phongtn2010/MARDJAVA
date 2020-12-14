package com.nsw.mard.p17.model;

/***
*
*
* @class Page
* Created by Nguyen Van Quang
* 11/12/2018 10:33:50
*
*/
import java.util.List;

public class Page <T> {

	private List<T> content;
	private long totalElements;
	private boolean last;
	private long totalPages;
	private int size;
	private long number;
	private boolean first;
	private long numberOfElements;
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public long getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(long numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	
	@Override
	public String toString() {
		return "Page [content=" + content + ", totalElements=" + totalElements + ", last=" + last + ", totalPages=" + totalPages + ", size=" + size + ", number=" + number + ", first=" + first + ", numberOfElements=" + numberOfElements + "]";
	}
	
}
