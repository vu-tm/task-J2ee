package com.example18.Exception;

public class BookIdMismatchException extends RuntimeException {
    public BookIdMismatchException() {
        super("Book not found");
    }
}
