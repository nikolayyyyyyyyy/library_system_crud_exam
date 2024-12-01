package library_system_api.library.exceptions;

public class EntityNotFoundInDatabaseException extends RuntimeException {
    public EntityNotFoundInDatabaseException(String message) {
        super(message);
    }
}
