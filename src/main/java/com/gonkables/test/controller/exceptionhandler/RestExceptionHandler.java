package com.gonkables.test.controller.exceptionhandler;

import com.gonkables.test.exception.ConflictException;
import com.gonkables.test.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * Exception Handler para devolver estado 409 - Conflict
     * @param e {@link RuntimeException}
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(value = {ConflictException.class})
    public ResponseEntity<?> handlerConflict(RuntimeException e){
        LOGGER.error("ERROR: ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * Exception Handler para devolver estado 404 - Not Found
     * @param e {@link RuntimeException}
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<?> handlerNotFound(RuntimeException e){
        LOGGER.error("ERROR: ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Exception Handler para devolver estado 500 - Internet server error
     * @param e {@link Exception}
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handlerInternalError(Exception e){
        LOGGER.error("ERROR: ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
