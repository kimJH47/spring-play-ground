package com.springplayground.webclient.api;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    public Response<?> find() {
        return new Response<>("find", HttpStatus.OK);
    }
}
