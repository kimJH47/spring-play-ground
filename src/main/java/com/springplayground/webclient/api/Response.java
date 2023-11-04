package com.springplayground.webclient.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class Response<T> {
    private T entity;
    private HttpStatus httpStatus;
}
