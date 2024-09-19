package com.arifng.play_es;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.support.HttpHeaders;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.arifng.play_es.repository")
public class Config {

    public @Nonnull ClientConfiguration clientConfiguration() {
        Supplier<HttpHeaders> headersSupplier = () -> {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            return headers;
        };
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                //.withHeaders(headersSupplier)
                .build();
    }

    @Bean
    public RestClient restClient() {
        return RestClient.builder(new HttpHost("localhost", 9200, "http"))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Content-type", "application/json")
                })
                .setHttpClientConfigCallback(httpClientBuilder -> {
                    httpClientBuilder.disableAuthCaching();

                    httpClientBuilder.addInterceptorLast((HttpResponseInterceptor)
                            (response, context) ->
                                    response.addHeader("X-Elastic-Product", "Elasticsearch"));
                    return httpClientBuilder;
                })
                .build();
    }
}
