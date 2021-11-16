package ru.pinguin.jokesmessenger.common.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;
import org.zalando.problem.spring.web.advice.AdviceTrait;

/**
 * @author Stepan Khudyakov.
 */
public interface IExceptionHandler extends AdviceTrait {

    default ThrowableProblem createCause(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        return Problem.builder()
                .withDetail(throwable.getMessage())
                .withCause(createCause(throwable.getCause()))
                .build();
    }

    default ResponseEntity<Problem> create(Status status, Throwable t, String title, NativeWebRequest req) {
        return create(status, t, title, t.getMessage(), req);
    }

    default ResponseEntity<Problem> create(Status status, Throwable t, String title, String detail,
                                           NativeWebRequest req) {
        ThrowableProblem problem = Problem.builder()
                .withStatus(status)
                .withTitle(title)
                .withDetail(detail)
                .withCause(createCause(t.getCause()))
                .build();
        return create(problem, req);
    }

    default ResponseEntity<Problem> create(Status status, String title, String detail, NativeWebRequest req) {
        ThrowableProblem problem = Problem.builder()
                .withStatus(status)
                .withTitle(title)
                .withDetail(detail)
                .build();
        return create(problem, req);
    }

}
