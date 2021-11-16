package ru.pinguin.jokesmessenger.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

/**
 * @author Stepan Khudyakov.
 */
@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer problemObjectMapperModules() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.modules(new Module[] {
                new ProblemModule(),
                new JavaTimeModule(),
                new ConstraintViolationProblemModule()
        });
    }


}
