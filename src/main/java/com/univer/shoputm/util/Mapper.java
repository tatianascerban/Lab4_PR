package com.univer.shoputm.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Objects;

public class Mapper {
  private final static ObjectMapper objectMapper = new ObjectMapper();

  private static Mapper mapper;
  private Mapper() {

  }

  public static Mapper getInstance() {
    if(Objects.isNull(mapper)) {
      mapper = new Mapper();
    }
    return mapper;
  }

  public BodyPublisher mapToJson(Object object) {  //sereliarizare din obiect in json
    BodyPublisher bodyPublisher;
    try {
      bodyPublisher = BodyPublishers.ofString(objectMapper.writeValueAsString(object));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return bodyPublisher;
  }

  public <T> T mapToPojo(String obj, Class<T> clazz) { //deserializare
    try {
      return objectMapper.readValue(obj, clazz);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public <T> T mapToPojoList(String obj, TypeReference<T> reference) { //deserializare
    try {
      return objectMapper.readValue(obj, reference);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}

