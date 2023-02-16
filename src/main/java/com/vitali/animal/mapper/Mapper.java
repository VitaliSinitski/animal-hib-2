package com.vitali.animal.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
