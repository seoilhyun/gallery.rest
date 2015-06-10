package com.gallery.web.controller.support.converter;

import com.gallery.web.controller.support.exception.EntityConverterException;
import com.sun.istack.internal.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 10.
 * Time: 오전 11:14
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
public abstract class AbstractEntityConverter<ID> implements GenericConverter {

    private final Set<ConvertiblePair> convertiblePairs;

    @PersistenceContext
    private EntityManager entityManager;

    public AbstractEntityConverter() {
        this.convertiblePairs = initConvertibleTypes();
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        log.debug("convert - source: {}, sourceType: {}, targetType: {}", new Object[]{source, sourceType, targetType});

        try {
            ID id = convertId(source, sourceType);

            Object entity =  entityManager.getReference(targetType.getType(), id);

            log.debug("found entity - type: {}, id: {}", new Object[]{targetType.getType(), id});
            log.trace("found entity: {}", entity);

            return entity;
        } catch (Exception e) {
            if(targetType.getAnnotation(Nullable.class) != null) {
                return null;
            }

            throw new EntityConverterException(targetType.getType(), null, e);
        }
    }

    public abstract Set<ConvertiblePair> initConvertibleTypes();
    public abstract ID convertId(Object source, TypeDescriptor sourceType);
}
