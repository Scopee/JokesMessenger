package ru.pinguin.jokesmessenger.elastic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.pinguin.jokesmessenger.data.Joke;

import java.util.List;
import java.util.Random;

@Service
public class ElasticService {

    private final JokesRepository jokesRepository;

    private final Random random = new Random();

    public ElasticService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public String getJokeOrNull(String word) {
        Page<Joke> jokeByWord = jokesRepository.findJokeByWord(word, PageRequest.of(0, 100));
        List<Joke> jokes = jokeByWord.get().toList();
        if (jokes.size() == 0)
            return null;
        return jokes.get(random.nextInt(jokes.size())).getJoke();
    }
}
