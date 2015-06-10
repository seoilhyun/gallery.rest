package com.gallery.web.controller.support.exception;

import org.springframework.dao.DataAccessException;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 10.
 * Time: 오전 11:16
 * To change this template use File | Settings | File Templates.
 */
public class EntityConverterException extends DataAccessException {

    private static final long serialVersionUID = 8039151996820968719L;

    private Class<?> entityType;

    public EntityConverterException(Class<?> entityType, String msg, Throwable cause) {
        super(msg, cause);
    }

    public Class<?> getEntityType() {
        return entityType;
    }
}
