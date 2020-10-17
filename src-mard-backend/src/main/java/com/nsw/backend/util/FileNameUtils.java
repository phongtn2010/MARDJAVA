package com.nsw.backend.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileNameUtils {

    public static final Logger logger = LoggerFactory.getLogger(FileNameUtils.class);

    /**
     * Tao thu muc
     *
     * @param rootFolder
     * @return
     */
    public String generaFolderByRootAndDate(String rootFolder) {
        String filePathDateStr = generateFolder();
        String folder = rootFolder + "/" + filePathDateStr + "/";
        createFolderIfNotExist(folder);
        return folder;

    }

    /**
     * Tao file name ngau nhien
     *
     * @param fileExtension
     * @return
     */
    public String generateFileName(String fileExtension) {

        fileExtension = getSafeFileExtension(fileExtension);
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        String milisecond = String.valueOf(Calendar.getInstance().get(
                Calendar.MILLISECOND));
        String fileName = randomUUIDString + "-" + milisecond + "."
                + fileExtension;
        return fileName;
    }

    /**
     * Lay duoi file an toan
     *
     * @param fileExtension
     * @return
     */
    public String getSafeFileExtension(String fileExtension) {
        if (fileExtension == null || "".endsWith(fileExtension)) {
            return "pdf";
        }
        fileExtension = getSafeString(fileExtension);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileExtension.length(); i++) {
            char c = fileExtension.charAt(i);
            if (c != '.') {
                sb.append(c);
            }
        }
        String text = sb.toString();
        return text;
    }

    /**
     * Lay ten theo cach an toan
     *
     * @param str
     * @return
     */
    private String getSafeString(String str) {
        try {
            if (str == null) {
                return "null";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c != ' ' && c != '#' && c != '%' && c != '@' && c != '('
                        && c != ')' && c != '^' && c != ';' && c != ':'
                        && c != '*' && c != '?' && c != '|' && c != '<'
                        && c != '>' && c != 0) {
                    sb.append(c);
                }
            }
            str = removeVietnameseChar(sb.toString());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return str;
    }

    /**
     * Xoa ten vietnam
     *
     * @param name
     * @return
     */
    private String removeVietnameseChar(String name) {
        if (name == null) {
            return "null";
        }
        char[] vnChar = {'á', 'à', 'ả', 'ã', 'ạ', 'â', 'ấ', 'ầ', 'ẩ', 'ẫ',
            'ậ', 'ă', 'ắ', 'ằ', 'ẳ', 'ẵ', 'ặ', 'đ', 'é', 'è', 'ẻ', 'ẽ',
            'ẹ', 'ê', 'ế', 'ề', 'ể', 'ễ', 'ệ', 'í', 'ì', 'ỉ', 'ĩ', 'ị',
            'ó', 'ò', 'ỏ', 'õ', 'ọ', 'ô', 'ố', 'ồ', 'ổ', 'ỗ', 'ộ', 'ơ',
            'ớ', 'ờ', 'ở', 'ỡ', 'ợ', 'ú', 'ù', 'ủ', 'ũ', 'ụ', 'ư', 'ứ',
            'ừ', 'ử', 'ữ', 'ự', 'ý', 'ỳ', 'ỷ', 'ỹ', 'ỵ'};
        char[] engChar = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
            'a', 'a', 'a', 'a', 'a', 'a', 'a', 'd', 'e', 'e', 'e', 'e',
            'e', 'e', 'e', 'e', 'e', 'e', 'e', 'i', 'i', 'i', 'i', 'i',
            'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o',
            'o', 'o', 'o', 'o', 'o', 'u', 'u', 'u', 'u', 'u', 'u', 'u',
            'u', 'u', 'u', 'u', 'y', 'y', 'y', 'y', 'y'};
        char[] vnChar2 = {'Á', 'À', 'Ả', 'Ã', 'Ạ', 'Â', 'Ấ', 'Ầ', 'Ẩ', 'Ẫ',
            'Ậ', 'Ă', 'Ắ', 'Ằ', 'Ẳ', 'Ẫ', 'Ặ', 'Đ', 'É', 'È', 'Ẻ', 'Ẽ',
            'Ẹ', 'Ê', 'Ế', 'Ề', 'Ể', 'Ễ', 'Ệ', 'Í', 'Ì', 'Ỉ', 'Ĩ', 'Ị',
            'Ó', 'Ò', 'Ỏ', 'Õ', 'Ọ', 'Ô', 'Ố', 'Ồ', 'Ổ', 'Ỗ', 'Ộ', 'Ơ',
            'Ớ', 'Ờ', 'Ở', 'Ỡ', 'Ợ', 'Ú', 'Ù', 'Ủ', 'Ũ', 'Ụ', 'Ư', 'Ứ',
            'Ừ', 'Ử', 'Ữ', 'Ự', 'Ý', 'Ỳ', 'Ỷ', 'Ỹ', 'Ỵ', '?'};
        char[] engChar2 = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
            'A', 'A', 'A', 'A', 'A', 'A', 'A', 'D', 'E', 'E', 'E', 'E',
            'E', 'E', 'E', 'E', 'E', 'E', 'E', 'I', 'I', 'I', 'I', 'I',
            'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O',
            'O', 'O', 'O', 'O', 'O', 'U', 'U', 'U', 'U', 'U', 'U', 'U',
            'U', 'U', 'U', 'U', 'Y', 'Y', 'Y', 'Y', 'Y', '_'};
        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j < vnChar.length; j++) {
                if (name.charAt(i) == vnChar[j]) {
                    String nameResult = name.replace(vnChar[j], engChar[j]);
                    name = nameResult;
                }
            }
        }

        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j < vnChar2.length; j++) {
                if (name.charAt(i) == vnChar2[j]) {
                    String nameResult = name.replace(vnChar2[j], engChar2[j]);
                    name = nameResult;
                }
            }
        }
        String nameResult = name.trim();
        name = nameResult;

        return name;
    }

    /**
     * Tao thu muc
     *
     * @return
     */
    private String generateFolder() {

        Date date = new Date();
        String dateStr = convertDateToString(date);
        logger.info("generateFolder" + ":" + dateStr);
        return dateStr;
    }

    /**
     * Tao thu muc neu chua co
     *
     * @param folderPath
     * @return
     */
    public boolean createFolderIfNotExist(String folderPath) {
        boolean result;
        try {
            logger.info("createFolderIfNotExist" + ":" + folderPath);
            File theDir = new File(folderPath);
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
            result = true;
        } catch (SecurityException ex) {
            logger.error(ex.getMessage(), ex);
            result = false;
        }

        return result;
    }

    /**
     * Kiem tra ton tai
     *
     * @param filePath
     * @return
     */
    public boolean checkIsExist(String filePath) {
        boolean result;
        try {
            logger.info("checkIsExist" + ":" + filePath);
            File file = new File(filePath);
            if (file.exists()) {
                result = true;
            } else {
                result = false;
            }

        } catch (SecurityException ex) {
            logger.error(ex.getMessage());
            result = false;
        }
        return result;
    }

    /**
     * Convert Date thành String
     *
     * @param date
     * @return
     */
    public String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(date);
    }
}
