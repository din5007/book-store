package com.bnpp.bookstore.core.exceptionHandling;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
