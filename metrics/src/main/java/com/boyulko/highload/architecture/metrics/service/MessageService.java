package com.boyulko.highload.architecture.metrics.service;

import com.boyulko.highload.architecture.metrics.data.Message;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Autowired
  RestHighLevelClient elasticsearchClient;


  public void saveMessage() throws IOException {

    var id = UUID.randomUUID().toString();
    var message = new Message(id, "header for ".concat(id), "description for ".concat(id));

    mongoTemplate.save(message);

    BulkRequest request = new BulkRequest();
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put("id", id);
    jsonMap.put("header", "header for ".concat(id));
    jsonMap.put("description", "description for ".concat(id));
    IndexRequest indexRequest = new IndexRequest("posts").id("1").source(jsonMap);
    request.add(indexRequest);

    BulkResponse response = elasticsearchClient.bulk(request, RequestOptions.DEFAULT);
  }

}
