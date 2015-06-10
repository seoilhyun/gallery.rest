package com.gallery.web.controller;

import com.gallery.core.service.common.ImageFileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 10.
 * Time: 오전 11:04
 * To change this template use File | Settings | File Templates.
 */
public class AbstractCommonController {

    @Autowired protected ModelMapper modelMapper;
    @Autowired protected ImageFileService fileService;

}

