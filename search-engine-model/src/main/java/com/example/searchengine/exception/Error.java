package com.example.searchengine.exception;

import lombok.Data;

@Data
public class Error {

    private Integer errorCode;

    private String errorMessage;
}
