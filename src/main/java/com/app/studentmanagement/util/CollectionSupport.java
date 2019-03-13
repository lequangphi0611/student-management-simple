package com.app.studentmanagement.util;

import java.util.HashSet;
import java.util.Set;

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

    public Iterable<D> convert(Iterable<E> entitys, Parser<E, D> parser) {
        Set<D> dtos = new HashSet<>();
        entitys
            .forEach(entity -> dtos.add(parser.parseDTOTo(entity)));
        return dtos;
    }
    
}