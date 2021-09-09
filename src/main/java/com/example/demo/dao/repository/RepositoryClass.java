package com.example.demo.dao.repository;

import com.example.demo.dao.beans.IeFormInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface RepositoryClass extends JpaRepository<IeFormInventory, BigInteger> {

  @Query("SELECT ifi FROM RepositoryClass ifi WHERE firstColumn is null AND secondColumn = :secondColumn OR thirdColumn = :thirdColumn " +
    "OR intacFlg = :intacFlg OR nonIntacFlg = :nonIntacFlg AND secondColumn = :secondColumn ")
  List<IeFormInventory> findMyColumns(@Param("secondColumn") String printFlg,
                                      @Param("thirdColumn") String thirdColumn, @Param("sixColumn") String sixColumn,
                                      @Param("fourthColumn") String fourthColumn, @Param("fifthColumn") String fifthColumn);
}
