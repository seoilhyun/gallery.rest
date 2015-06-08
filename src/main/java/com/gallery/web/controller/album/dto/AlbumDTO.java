package com.gallery.web.controller.album.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 1.
 * Time: 오전 11:13
 * To change this template use File | Settings | File Templates.
 */
public class AlbumDTO {

    @Data
    public static class Request {

        @NotBlank
        private String title;

        @NotBlank
        private String content;
    }

    @Data
    public static class Response {
        private String title;
    }


    @Data
    public static class Update {

        @NotBlank
        private String title;

        @NotBlank
        private String content;
    }


}
