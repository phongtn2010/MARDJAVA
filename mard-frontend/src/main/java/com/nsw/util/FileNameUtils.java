/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.util;

/**
 *
 * @author hieptran
 */
public class FileNameUtils {
    
    public static String getFileExtension(String filePath) {
        String reversePath = StringUtils.reverse(filePath);
        String reverseExtension = reversePath.split("\\.")[0];
        return StringUtils.reverse(reverseExtension);
    }
    
    public static String toSafeFileName(String fileName) {
        // Chuyển sang tiếng việt không dấu
        fileName = StringUtils.removeAccent(fileName);
        // Loại bỏ các ký tự đặc biệt
        fileName = fileName.replace("\\", "")
                .replace("/", "")
                .replace("..", "")
                .replace("|", "")
                .replace("<", "")
                .replace(">", "")
                .replace("\"", "")
                .replace("!", "")
                .replace("*", "")
                .replace(":", "")
                .replace("\0", "");
        return fileName;
    }
    
    public static String toSafeFileName(String fileName, int length) {
        fileName  = toSafeFileName(fileName); 
        if(fileName.length() <= length){
            return fileName;
        }
        else{
            String ext = getFileExtension(fileName);
            fileName = fileName.substring(0, length);
            if(fileName.endsWith(".")){
                return fileName + ext;
            }
            return fileName + "." + ext;
        }
    }  
}
