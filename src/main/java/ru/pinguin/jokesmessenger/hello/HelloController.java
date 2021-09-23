package ru.pinguin.jokesmessenger.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Stepan Khudyakov.
 */
@RestController
@RequiredArgsConstructor
public class HelloController implements HelloApi{

    private final HelloService helloService;

    @Override
    public HelloDto getHello() {
        return helloService.getHello();
    }
}
