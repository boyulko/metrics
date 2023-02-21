package com.boyulko.highload.architecture.metrics.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "esMessage")
public class EsMessage {

  @Id
  public String id;

  @Field(type = FieldType.Text, name = "header")
  public String header;
  @Field(type = FieldType.Text, name = "description")
  public String description;

  public EsMessage() {
  }


  public EsMessage(String id, String header, String description) {
    this.id = id;
    this.header = header;
    this.description = description;
  }

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

  @Override
  public String toString() {
    return "EsMessage{" +
        "id='" + id + '\'' +
        ", header='" + header + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
