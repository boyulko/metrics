package com.boyulko.highload.architecture.metrics.data;

import org.springframework.data.annotation.Id;

public class Message {

  @Id
  public String id;

  public String header;
  public String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Message() {}


  public Message(String id, String header, String description) {
    this.id = id;
    this.header = header;
    this.description = description;
  }
}
