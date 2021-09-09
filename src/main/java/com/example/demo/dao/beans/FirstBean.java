package com.example.demo.dao.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FIRST_BEAN", schema = "mySchema")
public class FirstBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "FIRST_COLUMN", unique = true, nullable = false)
  private Integer firstColumn;

  @Column(name = "SECOND_COLUMN")
  private Integer secondColumn;

  @Column(name = "THIRD_COLUMN")
  private Integer thirdColumn;

  @Column(name = "FOURTH_COLUMN")
  private String fourthColumn;

  @Column(name = "FIFTH_COLUMN")
  private String fifthColumn;
}
