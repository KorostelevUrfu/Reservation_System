package korostelev.ivan.reservation_system;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ReservationService.class);

    //Универсальный обработчик для неописанных случаев
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception e){
        log.error("Handle exception", e);
        ErrorResponseDto errorDto = new ErrorResponseDto("Internal server error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorDto);
    }

    //Обработчик для 404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEntityNotFound(Exception e){
        log.error("Handle entityNotFoundException", e);
        ErrorResponseDto errorDto = new ErrorResponseDto("Not found", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorDto);
    }

    //Обработчик для 400
    @ExceptionHandler(exception = {
            IllegalArgumentException.class,
            IllegalStateException.class,
            MethodArgumentNotValidException.class //невалидные данные
    })
    public ResponseEntity<ErrorResponseDto> handleBadRequest(Exception e){
        log.error("Handle handleBadRequest", e);
        ErrorResponseDto errorDto = new ErrorResponseDto("Bad Request", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorDto);
    }

}
