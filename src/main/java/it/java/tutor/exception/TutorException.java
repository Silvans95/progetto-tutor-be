package it.java.tutor.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class TutorException extends Exception {

    private HttpStatus httpStatus;
    private String message;

    public static TutorException badRequest(String message) {
        return TutorException.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(message)
                .build();
    }

    public static TutorException notFound(String message) {
        return TutorException.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(message)
                .build();
    }


}
