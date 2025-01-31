package org.triplem.insurancedataservice.util.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleGeneralException(RuntimeException ex, WebRequest request) {

        String bodyOfResponse = "Application crashed while processing data.";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);

    }

    @ExceptionHandler(value = {FeeProcessException.class, RegionNotFoundException.class})
    protected ResponseEntity<Object> handleFeeException(RuntimeException ex, WebRequest request) {

        String bodyOfResponse = "Something went wrong while processing the fee.";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);

    }

}
