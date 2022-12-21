package com.tarus.cars.error;

import com.tarus.cars.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler
extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<ErrorMessage> carNotFoundException(CarNotFoundException exception,
                                                            WebRequest request){
ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
        exception.getMessage());
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
