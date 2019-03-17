package com.app.studentmanagement.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @param <D> is DTO Class type
 * @param <E> is Entity Class type
 */
@Component
public class CollectionSupport<E, D> {

    public interface Parser<E, D> {
        D parseDTOTo(E e);
    }

    public List<D> convert(Iterable<E> entitys, Parser<E, D> parser) {
        List<D> dtos = new ArrayList<>();
        entitys
            .forEach(entity -> dtos.add(parser.parseDTOTo(entity)));
        return dtos;
    }
    
}