package com.example.demo.service.impl;

import com.example.demo.commonbeans.CustomException;
import com.example.demo.dao.beans.IeFormInventory;
import com.example.demo.dao.repository.RepositoryClass;
import com.example.demo.dao.repository.SecondRepoClass;
import com.example.demo.model.response.fourthVariable;
import com.example.demo.model.response.SecondResponseClass;
import com.example.demo.model.response.FirstResponseClass;
import com.example.demo.service.ServiceClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ServiceClassImpl implements ServiceClass {

  private static final Logger logger = LogManager.getLogger(ServiceClass.class);

  private SecondRepoClass povertyLevelRepository;

  @Autowired
  RepositoryClass repositoryClass;

  public ServiceClassImpl(){

  }

  @Autowired
  public ServiceClassImpl(
      SecondRepoClass povertyLevelRepository) {
    this.povertyLevelRepository = povertyLevelRepository;
  }

  /**
   *
   * @param progName
   * @param activeFlg
   * @return
   */
  @Override
  public List<FirstResponseClass> getIncomeLmt(String progName, String activeFlg) {
    return povertyLevelRepository.getIncomeLmt(progName, activeFlg, PageRequest.of(0, 14));
  }

  public fourthVariable getDocumentTabs(String printFlg, String batchFlg, String intacFlg, String nonIntacFlg, String formTypCd) throws Exception{
    fourthVariable documentTabTemplateInfos = new fourthVariable();

    try {
      List<IeFormInventory> ieFormInventories = repositoryClass.findMyColumns(printFlg, batchFlg, intacFlg, nonIntacFlg, formTypCd);
      List<SecondResponseClass> secondResponseClassList = new ArrayList<>();
      SecondResponseClass secondResponseClass = null;
      for (IeFormInventory ieFormInventory : ieFormInventories) {
        secondResponseClass = new SecondResponseClass();
        secondResponseClass.setFirstColumn(ieFormInventory.getFirstColumn());
        secondResponseClass.setSecondColumn(ieFormInventory.getSecondColumn());
        secondResponseClass.setThirdColumn(ieFormInventory.getThirdColumn());
        secondResponseClass.setFourthColumn(ieFormInventory.getFourthColumn());
        secondResponseClass.setFifthColumn(ieFormInventory.getFifthColumn());
        secondResponseClass.setSixColumn(ieFormInventory.getSixColumn());

        secondResponseClassList.add(secondResponseClass);
      }

      documentTabTemplateInfos.setFirstVariable(secondResponseClassList);

    } catch (Exception e) {
      logger.error("ServiceClassImpl.java --> getFirstVariable() " + e);
      if (e.getCause() != null) {
        String Cause = org.apache.commons.lang3.exception.ExceptionUtils.getRootCauseMessage(e.getCause());
        logger.error("ServiceClassImpl.java : getFirstVariable() " + Cause);
        if (Cause != null && (Cause.contains("ConnectTimeoutException") || Cause.contains("UnknownHostException") || Cause.contains("connection refused"))) {
          logger.error("ServiceClassImpl() :: connectTimeOut  " + Cause);
          throw new CustomException(ServiceClassImpl.class, e, "ccmn-rand-service|SERVICENOTAVAILABLE|CCAPI", null);
        } else if (Cause != null && Cause.contains("Read timed out")) {
          logger.error("SomeClass() :: ReadTimeOut  " + Cause);
          throw new CustomException(ServiceClassImpl.class, e, "ccmn-rand-service|TIMEOUT|ccapi", null);
        } else {
          throw new CustomException(ServiceClassImpl.class, e, "ccmn-rand-service|SUBSYSTEMEXCEPTION|ccapi", null);
        }
      } else {
        throw new CustomException(ServiceClassImpl.class, e, "ccmn-rand-service|SUBSYSTEMEXCEPTION|ccapi", null);
      }
    }

    return documentTabTemplateInfos;
  }
}
