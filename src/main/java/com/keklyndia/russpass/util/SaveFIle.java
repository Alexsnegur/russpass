package com.keklyndia.russpass.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveFIle {
    public static String saveFile(MultipartFile multipartFile) throws FileSystemException {
        String fileName = "src/main/resources/photo/" + multipartFile.getOriginalFilename();
        assert fileName != null;
        if (checkFile(fileName)) {
            File file = new File(fileName);
            try (OutputStream os = new FileOutputStream(file)) {
                os.write(multipartFile.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return fileName;
        } else throw new FileSystemException("Пошел нахуй");
    }
    public static boolean checkFile(String fileName){
        String[] extensionOfImg = {".png", ".jpg"};
        int dotIndex = fileName.lastIndexOf('.');
        String extension = (dotIndex == -1) ? "" : fileName.substring(dotIndex);
        System.out.println(extension);
        return Arrays.asList(extensionOfImg).contains(extension);
    }
}
