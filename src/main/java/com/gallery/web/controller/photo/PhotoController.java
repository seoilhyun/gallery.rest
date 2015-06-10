package com.gallery.web.controller.photo;

import com.gallery.core.domain.photo.Photo;
import com.gallery.core.domain.support.file.ImageFile;
import com.gallery.core.repository.photo.PhotoRepository;
import com.gallery.core.service.photo.PhotoService;
import com.gallery.web.controller.AbstractCommonController;
import com.gallery.web.controller.photo.dto.PhotoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 5.
 * Time: 오후 6:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/photos")
public class PhotoController extends AbstractCommonController {

    @Autowired private PhotoService service;


    //TODO
    // to-be : spring restful api file upload
    // check : @RequestPart
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createNewPhoto(@ModelAttribute PhotoDTO.Request request, BindingResult result) {
        if(result.hasErrors()) {

        }

        try{

            MultipartFile image = request.getImage();
            ImageFile imageFile = fileService.saveFileToStorage(image.getName(), image.getContentType(), image.getInputStream());

            Photo photo = new Photo(request.getCaption(), imageFile);
            service.createNewPhoto(photo);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
