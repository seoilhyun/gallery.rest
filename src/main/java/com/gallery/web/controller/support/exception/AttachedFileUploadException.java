package com.gallery.web.controller.support.exception;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 10.
 * Time: 오후 5:17
 * To change this template use File | Settings | File Templates.
 */
public class AttachedFileUploadException extends RuntimeException {

    private static final long serialVersionUID = -7305496242383581711L;

    public AttachedFileUploadException(String msg) {
        super(msg);
    }

    public AttachedFileUploadException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
