package com.example.demo.dao.repository;

import com.example.demo.dao.beans.FirstBean;
import com.example.demo.model.response.FirstResponseClass;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondRepoClass extends JpaRepository<FirstBean, Integer>{

  /**
   *
   * @param progName
   * @param secondColumn
   * @return
   */
  @Query(value = "select  new com.example.demo.model.response.FirstResponseClass(firstColumn, secondColumn) " +
      "FROM FirstBean WHERE firstColumn = :firstColumn and secondColumn = :secondColumn")
  List<FirstResponseClass> getIncomeLmt(String progName, @Param("secondColumn") String secondColumn, Pageable pageable);



}
