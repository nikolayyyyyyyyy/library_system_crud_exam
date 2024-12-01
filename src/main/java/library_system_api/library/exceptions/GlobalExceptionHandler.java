package library_system_api.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundInDatabaseException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundInDatabaseException authorNotFoundException){
        return new ResponseEntity<>(authorNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyExistInTheDatabaseException.class)
    public ResponseEntity<String> handleEntityAlreadyExistException(EntityAlreadyExistInTheDatabaseException entityAlreadyExistInTheDatabaseException)
    {
        return new ResponseEntity<>(entityAlreadyExistInTheDatabaseException.getMessage(),HttpStatus.ALREADY_REPORTED);
    }
}
