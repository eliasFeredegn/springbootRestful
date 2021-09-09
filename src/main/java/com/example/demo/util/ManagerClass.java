package com.example.demo.util;

import java.util.ArrayList;

import com.example.demo.model.request.RequestClass;
import com.example.demo.model.response.FirstResponseClass;
import com.example.demo.model.response.MainTemplate;
import com.example.demo.model.response.Routes;
import com.example.demo.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Component
public class ManagerClass {

  private ServiceClass service;

  public ManagerClass(){

  }

  @Autowired
  public ManagerClass(ServiceClass serviceClass) {
    this.service = serviceClass;
  }




  /**
   * @param form
   * @param formInfo
   */
  private void setCnlfForm(RequestClass form, MainTemplate formInfo) {
    RestTemplate restTemplate = new RestTemplate();
    Routes[] schedule = restTemplate.getForObject("https://svc.metrotransit.org/NexTrip/Routes?format=json", Routes[].class);
    System.out.println(schedule);
    String activeFlg = "Y";
    List<FirstResponseClass> caseClientDetails = service.getIncomeLmt(form.getFourthColumn().get(0), activeFlg);
    List<FirstResponseClass> cmlbTemplateInfos = new ArrayList<>();
    if (!CollectionUtils.isEmpty(caseClientDetails)) {
      for (FirstResponseClass claimDetail : caseClientDetails) {
        FirstResponseClass clients = new FirstResponseClass();

        // clients.setClientFstNm(claimDetail.getClientFstNm());
        // clients.setClientMidlNm(claimDetail.getClientMidlNm());
        // clients.setClientLstNm(claimDetail.getClientLstNm());
        // clients.setDueDt(claimDetail.getDueDt());

        cmlbTemplateInfos.add(clients);
      }
    }

   // formInfo.setResponseHeader(cmlbTemplateInfos);
  }
}
