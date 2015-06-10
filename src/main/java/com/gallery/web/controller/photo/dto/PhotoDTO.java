package com.gallery.web.controller.photo.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 5.
 * Time: 오후 6:13
 * To change this template use File | Settings | File Templates.
 */
public class PhotoDTO {

    @Data
    public static class Request {

        private String caption;

        private MultipartFile image;

    }

    @Data
    public static class Response {

        private String caption;

        private String imageName;

        private String imagePath;

        private String imageFile;
    }
}
