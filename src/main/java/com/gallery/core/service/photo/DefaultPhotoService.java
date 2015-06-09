package com.gallery.core.service.photo;

import com.gallery.core.domain.photo.Photo;
import com.gallery.core.repository.photo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 9.
 * Time: 오후 3:15
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class DefaultPhotoService implements PhotoService {

    @Autowired private PhotoRepository repository;

    @Override
    public Photo createNewPhoto(Photo photo) {
        return repository.save(photo);
    }
}
