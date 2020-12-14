package com.nsw.mard.helper;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Mard07Helper {

    private Mard07Helper() {
    }

    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static final String TMP_FOLDER = USER_DIRECTORY + "/tmp";

    public static File saveMultipartFileToTmpFolder(MultipartFile file) throws IOException {
        return saveInputstreamToTmpFolder(file.getOriginalFilename(), file.getInputStream());
    }

    public static File saveInputstreamToTmpFolder(String fileName, InputStream inputStream) throws IOException {
        File root = new File(TMP_FOLDER);
        if (!root.exists()) {
            root.mkdirs();
        }
        File currentFile = new File(root, fileName);
        FileOutputStream fos = new FileOutputStream(currentFile);
        IOUtils.copy(inputStream, fos);
        fos.flush();
        fos.close();
        return currentFile;
    }
}
