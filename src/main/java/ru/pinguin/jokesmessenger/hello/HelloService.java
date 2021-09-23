package ru.pinguin.jokesmessenger.hello;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Stepan Khudyakov.
 */
@Service
public class HelloService {

    public HelloDto getHello() {
        HelloDto dto = new HelloDto();
        dto.setMessage("Hello");
        dto.setDate(LocalDateTime.now());
        return dto;
    }
}
