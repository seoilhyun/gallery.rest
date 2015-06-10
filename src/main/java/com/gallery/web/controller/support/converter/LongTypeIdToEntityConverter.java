package com.gallery.web.controller.support.converter;

import com.gallery.core.domain.album.Album;
import com.gallery.core.domain.photo.Photo;
import com.gallery.core.domain.support.file.ImageFile;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.util.NumberUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 10.
 * Time: 오전 11:14
 * To change this template use File | Settings | File Templates.
 */
public class LongTypeIdToEntityConverter extends AbstractEntityConverter<Long> {

    @Override
    public Set<ConvertiblePair> initConvertibleTypes() {
        Set<Class<?>> targetTypes = new HashSet<Class<?>>();

        targetTypes.add(ImageFile.class);
        targetTypes.add(Album.class);
        targetTypes.add(Photo.class);


        Set<ConvertiblePair> convertiblePairs = new HashSet<GenericConverter.ConvertiblePair>();

        for(Class<?> targetType : targetTypes) {
            convertiblePairs.add(new ConvertiblePair(Long.class, targetType));
            convertiblePairs.add(new ConvertiblePair(String.class, targetType));
        }

        return convertiblePairs;
    }

    @Override
    public Long convertId(Object source, TypeDescriptor sourceType) {
        if(Long.class.equals(sourceType.getType())) {
            return (Long) source;
        } else {
            return NumberUtils.parseNumber(source.toString(), Long.class);
        }
    }
}

