/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.helper;

import com.nsw.util.LogUtil;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author PhongNguyen
 */
public class CAHelper {

    public static String GetHashData(String data) throws UnsupportedEncodingException {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] result = md.digest(data.getBytes("UTF-8"));
            hash = ByteArrayToString(result);
        } catch (Exception e) {
            LogUtil.addLog(e);
            hash = "";
        }
        return hash;
    }

    public static String ByteArrayToString(byte[] ba) {
        StringBuilder hex = new StringBuilder(ba.length * 2);
        for (byte b : ba) {
            hex.append(String.format("{0:x2}", b));
        }
        return hex.toString();
    }
}
