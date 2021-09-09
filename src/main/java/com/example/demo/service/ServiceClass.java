package com.example.demo.service;

import com.example.demo.model.response.fourthVariable;
import com.example.demo.model.response.FirstResponseClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceClass {

  /**
   *
   * @param progName
   * @param activeFlg
   * @return
   */
  List<FirstResponseClass> getIncomeLmt(String progName, String activeFlg);

  fourthVariable getDocumentTabs(String printFlg, String batchFlg, String intacFlg, String nonIntacFlg, String formTypCd) throws Exception;
}
