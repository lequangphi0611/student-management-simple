package com.app.studentmanagement.util;

/**
 * 
 * @param <E> is Entity Class Type
 * @param <D> is DTO Class Type
 */
public interface Mapper<E, D> {

    D parseDTO(E entity);

    E parseEntity(D dto);
    
}