package com.nsw.mic.p03.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseJson03 {

	private boolean success;
	private Object data;
	private Long total;
	private String message;
	private int status;
	private String gatewayMessage;
	private String exception;


   
    
}
