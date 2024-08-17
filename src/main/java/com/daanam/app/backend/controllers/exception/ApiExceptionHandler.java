package com.daanam.app.backend.controllers.exception;

import com.daanam.app.backend.dtos.ErrorMessageDto;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({PersistenceException.class, NoResultException.class, RuntimeException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorMessageDto> handleRuntimeExceptions(Exception e, WebRequest request) {
    ErrorMessageDto errorMessageDto = ErrorMessageDto.builder()
            .timestamp(LocalDateTime.now())
            .type(e.getClass().getName())
            .message(e.getMessage())
            .cause(e.getCause())
            .build();

    return ResponseEntity.badRequest().body(errorMessageDto);
  }

  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ErrorMessageDto> handleAllExceptions(Exception e, WebRequest request) {
    ErrorMessageDto errorMessageDto = ErrorMessageDto.builder()
            .timestamp(LocalDateTime.now())
            .type(e.getClass().getName())
            .message(e.getMessage())
            .cause(e.getCause())
            .build();

    return ResponseEntity.internalServerError().body(errorMessageDto);
  }
}
