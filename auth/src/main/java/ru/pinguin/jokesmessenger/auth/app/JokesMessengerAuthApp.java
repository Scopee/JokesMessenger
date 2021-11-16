package ru.pinguin.jokesmessenger.auth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Stepan Khudyakov.
 */
@SpringBootApplication(scanBasePackages = "ru.pinguin")
public class JokesMessengerAuthApp {

    public static void main(String[] args) {
        SpringApplication.run(JokesMessengerAuthApp.class, args);
    }
}
