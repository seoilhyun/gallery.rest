package com.gallery.core.service.common;

import com.gallery.core.domain.support.file.ImageFile;
import com.gallery.web.controller.support.exception.AttachedFileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 10.
 * Time: 오후 4:17
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ImageFileService {

    @Value("${attachedfile.path}")
    private String path;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // File upload

    public ImageFile saveFileToStorage(String fileName, String contentType, InputStream inputStream) throws IOException {
        File saveFile = createFile();

        ImageFile file = new ImageFile();

        file.setName(fileName);
        file.setContentType(contentType);

        FileCopyUtils.copy(inputStream, new FileOutputStream(saveFile));

        file.setPath(saveFile.getPath());
        file.setSize(saveFile.length());
        file.setFile(saveFile.getName());

        return file;
    }

    private File createFile() {
        try {
            String savePath = createSavePath();
            String saveFileName = UUID.randomUUID().toString();

            // 파일이 있으면 다시 시도
            File saveFile = new File(path + savePath + saveFileName);
            if(saveFile.exists())
                return createFile();

            // 파일 생성
            return saveFile;

        } catch (Exception e) {
            throw new AttachedFileUploadException("파일 업로드에 실패했습니다.", e);
        }
    }

    private String createSavePath() {
        String savePath = dateFormat.format(Calendar.getInstance().getTime()) + File.separator;

        File saveDir = new File(path + savePath);
        if(!saveDir.exists())
            saveDir.mkdir();

        return savePath;
    }

}

