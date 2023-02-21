package com.boyulko.highload.architecture.metrics.config;

import com.mongodb.ConnectionString;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.actuate.elasticsearch.ElasticsearchRestHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class EsConfig {

  @Bean
  public RestHighLevelClient elasticsearchClient() {
    String connectionString = "elasticsearch:9200";
    final ClientConfiguration clientConfiguration =
        ClientConfiguration
            .builder()
            .connectedTo(connectionString)
            .build();
    return RestClients.create(clientConfiguration).rest();
  }

  @Bean
  public ElasticsearchRestHealthIndicator elasticsearchHealthIndicator() {
    return new ElasticsearchRestHealthIndicator(elasticsearchClient());
  }

}
