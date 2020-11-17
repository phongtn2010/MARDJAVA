package com.vnsw.ws.common.service;

/**
*
* @author Linhdx
*/
public interface EncryptService {
	String encrypt(String key, String value);
	String decrypt(String key, String encrypted);

}