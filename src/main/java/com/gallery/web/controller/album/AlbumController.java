package com.gallery.web.controller.album;

import com.gallery.core.domain.album.Album;
import com.gallery.core.repository.album.AlbumRepository;
import com.gallery.core.service.album.AlbumService;
import com.gallery.web.controller.album.dto.AlbumDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 1.
 * Time: 오전 11:12
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired private ModelMapper modelMapper;

    @Autowired private AlbumService service;
    @Autowired private AlbumRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createNewAlbum(@Valid @RequestBody AlbumDTO.Request request, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        Album newAlbum = modelMapper.map(request, Album.class);
        Album album = service.createNewAlbum(newAlbum);

        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAlbums() {
        List<Album> albums = repository.findAll();

        return new ResponseEntity<>(albums.stream().map(album -> modelMapper.map(album, AlbumDTO.Response.class)).collect(Collectors.toList()), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity getAlbum(@PathVariable Long id) {
        Album album = repository.findOne(id);

        if(album == null) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(modelMapper.map(album, AlbumDTO.Response.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method={ RequestMethod.PUT, RequestMethod.PATCH })
    public ResponseEntity updateAlbum(@PathVariable Long id, @Valid @RequestBody AlbumDTO.Update request, BindingResult result) {
        if(result.hasErrors()) {
            //
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        Album origin = repository.findOne(id);

        if(origin == null) {

        }

        Album updateAlbum = service.updateAlbum(origin, modelMapper.map(request, Album.class));

        return new ResponseEntity<>(modelMapper.map(updateAlbum, AlbumDTO.Response.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public ResponseEntity deleteAlbum(@PathVariable Long id) {
        Album album = repository.findOne(id);

        if(album == null) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        repository.delete(album);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
