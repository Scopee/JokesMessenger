package ru.pinguin.jokesmessenger.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Stepan Khudyakov.
 */
@RequestMapping(HelloApi.HELLO_API)
public interface HelloApi {

    String HELLO_API = "/api/v1/hello";

    @GetMapping
    HelloDto getHello();
}
