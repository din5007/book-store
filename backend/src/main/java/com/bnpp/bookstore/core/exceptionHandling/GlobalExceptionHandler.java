package com.bnpp.bookstore.core.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({ NotFoundException.class })
  public ResponseEntity<Object> handleNotFoundException(NotFoundException exception) {
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(exception.getMessage());
  }

  @ExceptionHandler({ AlreadyExistException.class })
  public ResponseEntity<Object> handleAlreadyExistException(
    AlreadyExistException exception
  ) {
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(exception.getMessage());
  }

  @ExceptionHandler({ RuntimeException.class })
  public ResponseEntity<Object> runTimeException(RuntimeException exception) {
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(exception.getMessage());
  }
}
