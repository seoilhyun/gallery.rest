package com.gallery.web.controller.album;

import com.gallery.core.domain.album.Album;
import com.gallery.core.repository.album.AlbumRepository;
import com.gallery.web.controller.AbstractCommonController;
import com.gallery.web.controller.album.dto.AlbumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 10.
 * Time: 오전 11:03
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/api/albums")
public class AlbumAPIController extends AbstractCommonController {

    @Autowired private AlbumRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAlbums() {
        List<Album> albums = repository.findAll();

        return new ResponseEntity<>(albums.stream().map(album -> modelMapper.map(album, AlbumDTO.Response.class)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{album}", method=RequestMethod.GET)
    public ResponseEntity getAlbum(@PathVariable Album album) {
        if(album == null) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(modelMapper.map(album, AlbumDTO.Response.class), HttpStatus.OK);
    }

}
