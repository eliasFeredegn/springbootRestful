package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direction implements Serializable {

  @JsonProperty("Text")
  private String text;

  @JsonProperty("Value")
  private String value;
}
