package ru.pinguin.jokesmessenger.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

/**
 * @author Stepan Khudyakov.
 */
@RestControllerAdvice
@Slf4j
public class WebExceptionHandler implements IExceptionHandler, ProblemHandling {

    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Problem> handleException(NotFoundException ex, NativeWebRequest request) {
        log.debug(ex.getMessage(), ex);
        return create(Status.NOT_FOUND, ex, "Not found", request);
    }

    @ExceptionHandler({AlreadyExistsException.class})
    protected ResponseEntity<Problem> handleException(AlreadyExistsException ex, NativeWebRequest request) {
        log.debug(ex.getMessage(), ex);
        return create(Status.CONFLICT, ex, "Already exists", request);
    }

}
