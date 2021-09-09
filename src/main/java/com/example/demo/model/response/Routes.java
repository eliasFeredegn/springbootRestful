package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Routes implements Serializable {

  public static final long serialVersionUID = 1L;

  @JsonProperty("Description")
  private String description;

  @JsonProperty("ProviderID")
  private String providerID;

  @JsonProperty("Route")
  private String route;
}
