package com.gallery.web.controller.photo;

import com.gallery.core.domain.photo.Photo;
import com.gallery.core.repository.photo.PhotoRepository;
import com.gallery.web.controller.AbstractCommonController;
import com.gallery.web.controller.photo.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 10.
 * Time: 오전 11:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/api/photos")
public class PhotoAPIController extends AbstractCommonController {

    @Autowired private PhotoRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getPhotos() {
        return new ResponseEntity(repository.findAll().stream().map(photo -> modelMapper.map(photo, PhotoDTO.Response.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{photo}", method = RequestMethod.GET)
    public ResponseEntity getPhoto(@PathVariable Photo photo) {
        if(photo == null) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(modelMapper.map(photo, PhotoDTO.Response.class), HttpStatus.OK);
    }

}
