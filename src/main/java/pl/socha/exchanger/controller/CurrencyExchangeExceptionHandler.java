package pl.socha.exchanger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.socha.exchanger.controller.exception.CurrencyExchangeException;
import pl.socha.exchanger.exception.CurrencyUnknownException;

@RestControllerAdvice
public class CurrencyExchangeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { CurrencyExchangeException.class, CurrencyUnknownException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, bodyOfResponse, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity(apiError, apiError.getStatus());
    }
}