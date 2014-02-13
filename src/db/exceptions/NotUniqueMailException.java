package db.exceptions;

public class NotUniqueMailException extends DBException {

    public NotUniqueMailException(String message) {
        super(message);
    }

    public NotUniqueMailException(String message, Throwable cause){
        super(message, cause);
    }

}
