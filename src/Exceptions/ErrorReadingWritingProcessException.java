package Exceptions;

public class ErrorReadingWritingProcessException extends RuntimeException{
    public ErrorReadingWritingProcessException(String message, Throwable cause) {
        super(message, cause);
    }
}
