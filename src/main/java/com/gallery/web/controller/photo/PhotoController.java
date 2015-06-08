package com.gallery.web.controller.photo;

import com.gallery.core.domain.photo.Photo;
import com.gallery.web.controller.photo.dto.PhotoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 5.
 * Time: 오후 6:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/photos")
public class PhotoController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createNewPhoto(@RequestBody PhotoDTO.Request request, BindingResult result) {
        if(result.hasErrors()) {
            //
        }

        Photo photo = new Photo(request.getCaption(), request.getImage());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
