package com.gallery.web.controller.photo;

import com.gallery.core.domain.photo.Photo;
import com.gallery.core.repository.photo.PhotoRepository;
import com.gallery.core.service.photo.PhotoService;
import com.gallery.web.controller.photo.dto.PhotoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 5.
 * Time: 오후 6:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/api/photos")
public class PhotoController {

    @Autowired private ModelMapper modelMapper;

    @Autowired private PhotoService service;
    @Autowired private PhotoRepository repository;

    //TODO
    // to-be : spring restful api file upload
    // check : @RequestPart
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createNewPhoto(@ModelAttribute PhotoDTO.Request request, BindingResult result) {
        if(result.hasErrors()) {

        }

        Photo photo = new Photo(request.getCaption(), request.getImage());

        service.createNewPhoto(photo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getPhotos() {
        return new ResponseEntity(repository.findAll().stream().map(photo -> modelMapper.map(photo, PhotoDTO.Response.class)).collect(Collectors.toList()), HttpStatus.OK);
    }
}
