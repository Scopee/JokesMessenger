package ru.pinguin.jokesmessenger.config;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "ru.pinguin.jokesmessenger.elastic")
@EnableConfigurationProperties(ElasticProperties.class)
@RequiredArgsConstructor
public class ElasticConfig extends AbstractElasticsearchConfiguration {

    private final ElasticProperties properties;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        String url = properties.getUrl();
        String username = properties.getUsername();
        String password = properties.getPassword();

        ClientConfiguration configuration;
        if (!StringUtils.isEmpty(username)) {
            configuration = ClientConfiguration.builder().connectedTo(url).withBasicAuth(username, password).build();
        } else {
            configuration = ClientConfiguration.builder().connectedTo(url).build();
        }
        return RestClients.create(configuration).rest();
    }
}