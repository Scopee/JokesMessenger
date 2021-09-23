package ru.pinguin.jokesmessenger.hello;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Stepan Khudyakov.
 */
@Data
public class HelloDto {

    private String message;

    private LocalDateTime date;

}
