package library_system_api.library.exceptions;

public class EntityAlreadyExistInTheDatabaseException extends RuntimeException {
    public EntityAlreadyExistInTheDatabaseException(String message) {
        super(message);
    }
}
