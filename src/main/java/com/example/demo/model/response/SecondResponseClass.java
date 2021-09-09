package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondResponseClass implements Serializable {

  private static final long serialVersionUID = 1L;

  private BigInteger firstColumn;

  private String secondColumn;

  private String thirdColumn;

  private String fourthColumn;

  private String fifthColumn;

  private String sixColumn;

  private String seventhColumn;

  private String eightColumn;

}
