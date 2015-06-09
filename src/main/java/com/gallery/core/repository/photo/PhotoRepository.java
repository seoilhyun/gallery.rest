package com.gallery.core.repository.photo;

import com.gallery.core.domain.photo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 9.
 * Time: 오후 3:15
 * To change this template use File | Settings | File Templates.
 */
public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
