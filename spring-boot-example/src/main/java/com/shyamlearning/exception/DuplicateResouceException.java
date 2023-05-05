package com.shyamlearning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicateResouceException  extends RuntimeException {

    public DuplicateResouceException(String message) {

        super(message);
    }
}
