package ru.pinguin.jokesmessenger.elastic;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ElasticService {
    final JokesRepository jokesRepository;

    public ElasticService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public String getJokeOrNull(String word) {
        jokesRepository.findJokeByWord(word, PageRequest.of(0,100));
        return null;
    }
}
