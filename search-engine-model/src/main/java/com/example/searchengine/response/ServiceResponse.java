package com.example.searchengine.response;

import lombok.Data;

@Data
public class ServiceResponse<T> {

    // data to return in response
    private T data;

    // for any exception, error object will be populated
    private Error error;
}
