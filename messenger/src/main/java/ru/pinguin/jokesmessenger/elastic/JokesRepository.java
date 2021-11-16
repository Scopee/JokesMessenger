package ru.pinguin.jokesmessenger.elastic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.pinguin.jokesmessenger.data.Joke;

public interface JokesRepository extends ElasticsearchRepository<Joke, String> {
    @Query("""
            {"bool":
                {"should":
                    [{"match":
                        {"joke": "?0"}
                        }]
                        }
                        }
            """)
    Page<Joke> findJokeByWord(String word, Pageable pageable);
}