package info.thecodinglive.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import info.thecodinglive.exception.UserNotFoundException;
import info.thecodinglive.model.ApiErrorDetail;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorDetail> handleUserNotFoundException(UserNotFoundException unfe){
        ApiErrorDetail errorDetail = new ApiErrorDetail();
        errorDetail.setTimeStamp(new Date());
        errorDetail.setCode(1002);
        errorDetail.setMessage(unfe.getMessage());

        return new ResponseEntity(errorDetail, HttpStatus.NOT_FOUND);
    }
}
