package com.gallery.core.repository.album;

import com.gallery.core.domain.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 1.
 * Time: 오전 11:19
 * To change this template use File | Settings | File Templates.
 */
public interface AlbumRepository  extends JpaRepository<Album, Long> {

}
