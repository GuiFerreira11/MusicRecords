package com.example.MusicRecords.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {
  private ObjectMapper mapper = new ObjectMapper();

  public <T> T convertFromJson(String json, Class<T> classe){
    try {
    return mapper.readValue(json, classe);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
