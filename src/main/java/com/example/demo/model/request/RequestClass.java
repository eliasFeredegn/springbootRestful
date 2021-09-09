package com.example.demo.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestClass implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer firstColumn;

  private String secondColumn;

  private Integer thirdColumn;

  private List<String> fourthColumn;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CST")
  private Date fifthColumn;

  public RequestClass(Integer thirdColumn) {
    this.thirdColumn = thirdColumn;
  }

  public RequestClass(int firstColumn, List<String> fourthColumn, Date fifthColumn) {
    this.firstColumn = firstColumn;
    this.fourthColumn = fourthColumn;
    this.fifthColumn = fifthColumn;
  }

  public RequestClass(int firstColumn, List<String> fourthColumn) {
    this.firstColumn = firstColumn;
    this.fourthColumn = fourthColumn;
  }

  public RequestClass() {}

}
