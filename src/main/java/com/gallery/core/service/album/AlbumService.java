package com.gallery.core.service.album;

import com.gallery.core.domain.album.Album;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 1.
 * Time: 오전 11:23
 * To change this template use File | Settings | File Templates.
 */
public interface AlbumService {

    public Album createNewAlbum(Album album);

    public Album updateAlbum(Album origin, Album update);
}
