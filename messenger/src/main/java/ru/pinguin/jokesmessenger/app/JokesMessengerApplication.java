package ru.pinguin.jokesmessenger.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Stepan Khudyakov.
 */
@SpringBootApplication(scanBasePackages = "ru.pinguin")
public class JokesMessengerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokesMessengerApplication.class, args);
    }

}
