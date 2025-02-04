package exceptiion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle ResourceAlreadyExistException
    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<Object> handleResourceAlreadyExistException(ResourceAlreadyExistException ex, WebRequest request) {
        // Create a custom response body as a POJO (Plain Old Java Object)
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                ex.getResourceName(),
                ex.getFieldName(),
                ex.getFieldValue()
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);  // 409 Conflict status
    }
}
