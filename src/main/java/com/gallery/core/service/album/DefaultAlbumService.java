package com.gallery.core.service.album;

import com.gallery.core.domain.album.Album;
import com.gallery.core.repository.album.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 1.
 * Time: 오전 11:19
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class DefaultAlbumService implements AlbumService {

    @Autowired private AlbumRepository repository;

    @Override
    public Album createNewAlbum(Album album) {
        return repository.save(album);
    }

    @Override
    public Album updateAlbum(Album origin, Album update) {

        if(StringUtils.hasText(update.getTitle())) {
            origin.setTitle(update.getTitle());
        }

        if(StringUtils.hasText(update.getContent())) {
            origin.setContent(update.getContent());
        }

        return repository.save(origin);
    }
}
