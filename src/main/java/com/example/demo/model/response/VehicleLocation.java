package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleLocation implements Serializable {

  public static final long serialVersionUID = 1L;

  @JsonProperty("Bearing")
  private int bearing;

  @JsonProperty("BlockNumber")
  private int blockNumber;

  @JsonProperty("Direction")
  private int direction;

  @JsonProperty("LocationTime")
  private String locationTime;

  @JsonProperty("Odometer")
  private int odometer;

  @JsonProperty("Route")
  private int route;

  @JsonProperty("Speed")
  private int speed;

  @JsonProperty("Terminal")
  private String terminal;

  @JsonProperty("VehicleLatitude")
  private double vehicleLatitude;

  @JsonProperty("VehicleLongitude")
  private double vehicleLongitude;
}
