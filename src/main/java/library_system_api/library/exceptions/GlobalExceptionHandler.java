package library_system_api.library.exceptions;

import library_system_api.library.exceptions.authorEx.AuthorNotFoundException;
import library_system_api.library.exceptions.authorEx.EntityAlreadyExistInTheDatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<String> handleAuthorNotFoundException(AuthorNotFoundException authorNotFoundException){
        return new ResponseEntity<>(authorNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyExistInTheDatabaseException.class)
    public ResponseEntity<String> handleEntityAlreadyExistException(EntityAlreadyExistInTheDatabaseException entityAlreadyExistInTheDatabaseException)
    {
        return new ResponseEntity<>(entityAlreadyExistInTheDatabaseException.getMessage(),HttpStatus.ALREADY_REPORTED);
    }
}
