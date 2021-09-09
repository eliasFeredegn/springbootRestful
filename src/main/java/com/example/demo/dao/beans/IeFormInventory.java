package com.example.demo.dao.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SECOND_BEAN" , schema = "SCHEMA")
public class IeFormInventory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "FIRST_COLUMN")
  private BigInteger firstColumn;

  @Column(name = "SECOND_COLUMN")
  private String secondColumn;

  @Column(name = "THIRD_COLUMN")
  private String thirdColumn;

  @Column(name = "FOURTH_COLUMN")
  private String fourthColumn;

  @Column(name = "FIFTH_COLUMN")
  private String fifthColumn;

  @Column(name = "SIX_COLUMN")
  private String sixColumn;

}
