package com.boyulko.highload.architecture.metrics.api;

import com.boyulko.highload.architecture.metrics.service.MessageService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainResource {

  @Autowired
  private MessageService service;

  @PostMapping("/messages")
  public ResponseEntity<Void> createMessage() throws IOException {
    service.saveMessage();
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
