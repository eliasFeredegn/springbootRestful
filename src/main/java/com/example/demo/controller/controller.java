package com.example.demo.controller;

import com.example.demo.dao.repository.RepositoryClass;
import com.example.demo.dao.repository.SecondRepoClass;
import com.example.demo.model.response.fourthVariable;
import com.example.demo.model.response.SecondResponseClass;
import com.example.demo.model.response.ThirdResponseClass;
import com.example.demo.model.response.FirstResponseClass;
import com.example.demo.model.response.MainTemplate;
import com.example.demo.service.ServiceClass;
import com.example.demo.util.ManagerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@RestController
public class controller {

  @Autowired
  SecondRepoClass secondRepoClass;

  @Autowired
  RepositoryClass repositoryClass;

  @Autowired
  ServiceClass serviceClass;

  private String regexPattern = "(\\d{13})([\\+\\-]\\d{4})";

  private String findNums = "(^[0-9]*$)(-)($[0-9]*$)";

  private String regexReplace = "($1)-($2)" ;





  ManagerClass managerClass = new ManagerClass();

  @GetMapping(path = "/cnlf")
  public MainTemplate getIncomeLmt() {

//    RestTemplate restTemplate = new RestTemplate();
//    Routes[] schedule = restTemplate.getForObject("https://svc.metrotransit.org/NexTrip/Routes?format=json", Routes[].class);
//    System.out.println(schedule);

//    ObjectMapper mapper = new ObjectMapper();

//    try {
//      Routes[] routes = mapper.readValue("https://svc.metrotransit.org/NexTrip/Routes?format=json", Routes[].class);
//      System.out.println(routes);
//    }catch (IOException e){
//      e.printStackTrace();
//    }

    List<FirstResponseClass> listOfFedPovertyLvl = secondRepoClass.getIncomeLmt("LIEAP", "Y", PageRequest.of(0, 14));

    Integer extraPplIncome;
    ThirdResponseClass thirdResponseClass = new ThirdResponseClass();
    MainTemplate formInfo = new MainTemplate();
    List<FirstResponseClass> cnlfTemplateInfos = new ArrayList<>();
    if (!CollectionUtils.isEmpty(listOfFedPovertyLvl)) {
      for (FirstResponseClass claimDetail : listOfFedPovertyLvl) {
        FirstResponseClass incomeLvl = new FirstResponseClass();

        incomeLvl.setNumPplHH(claimDetail.getNumPplHH());
        incomeLvl.setIncmLmt(claimDetail.getIncmLmt());

        cnlfTemplateInfos.add(incomeLvl);
      }
    }

    extraPplIncome = cnlfTemplateInfos.get(10).getIncmLmt() - cnlfTemplateInfos.get(9).getIncmLmt();
    thirdResponseClass.setFirstVariable(extraPplIncome);
    thirdResponseClass.setSecondVariable(cnlfTemplateInfos);
    formInfo.setResponseHeader(thirdResponseClass);
    return formInfo;
  }

  /**
   *
   * @param tenantCode
   * @param printFlg
   * @param batchFlg
   * @param intacFlg
   * @param nonIntacFlg
   * @param formTypCd
   * @return
   * @throws Exception
   */
  @GetMapping(path = "/getPATHPrintFormIDList")
  public fourthVariable getDocumentTabs(@RequestHeader(name = "tenantCode") String tenantCode,
                                        @RequestHeader(name = "eightColumn") String printFlg,
                                        @RequestHeader(name = "batchFlg") String batchFlg,
                                        @RequestHeader(name = "intacFlg") String intacFlg,
                                        @RequestHeader(name = "nonIntacFlg") String nonIntacFlg,
                                        @RequestHeader(name = "secondColumn") String formTypCd) throws Exception
  {


    List<SecondResponseClass> printFormList = new ArrayList<>();

    if(!StringUtils.isEmpty(tenantCode) && !StringUtils.isEmpty(printFlg) || !StringUtils.isEmpty(batchFlg) || !StringUtils.isEmpty(intacFlg) || !StringUtils.isEmpty(nonIntacFlg) && !StringUtils.isEmpty(formTypCd) ){
      tenantCode = tenantCode;
      printFlg = printFlg != null ? printFlg : null;
      batchFlg = batchFlg != null ? batchFlg : null;
      intacFlg = intacFlg != null ? intacFlg : null;
      nonIntacFlg = nonIntacFlg != null ? nonIntacFlg : null;
      formTypCd = formTypCd;
    }

    //printFormList = repositoryClass.findMyColumns(eightColumn, batchFlg, intacFlg, nonIntacFlg, secondColumn);

    fourthVariable documentTabTemplateInfos = serviceClass.getDocumentTabs(printFlg, batchFlg, intacFlg, nonIntacFlg, formTypCd);

    return documentTabTemplateInfos;
  }

//  @PostMapping("/hi")
//  public String index(@RequestBody RequestClass request) {
//    ObjectMapper mapper = new ObjectMapper();
//    RestTemplate restTemplate = new RestTemplate();
//
//    // Get routes http://svc.metrotransit.org/NexTrip/Routes
//    String theRoute = null;
//    Routes[] schedule = restTemplate.getForObject("https://svc.metrotransit.org/NexTrip/Routes", Routes[].class);
//    System.out.println("----------------------------");
//    for(Routes secondColumn: schedule){
//      if(request.getSecondColumn().equals(secondColumn.getSecondColumn())){
//        theRoute = secondColumn.getSecondColumn();
//      }
//      System.out.println(secondColumn.getDescription());
//      System.out.println(secondColumn.getProviderID());
//      System.out.println(secondColumn.getSecondColumn());
//      System.out.println("");
//      System.out.println("----------------------------");
//      System.out.println("");
//    }
//
//    String locationTime = getVehicleLocation(theRoute);
//    System.out.println(locationTime);
//    String direcccc = getDirection(theRoute, 1);
//    Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
//
//    Matcher matcher = pattern.matcher(locationTime);
//
//    boolean matchFound = matcher.find();
//
//   String theLocationTime = matcher.group(1);
//   String miliSeconds = matcher.group(2);
//
//   long minutes = (parseLong(theLocationTime)/1000)/60;
//
//    Calendar rightNow = Calendar.getInstance();
//    long timeMilli2 = rightNow.getTimeInMillis();
//
//    long nowInMins = (parseLong(theLocationTime)/1000) / 60;
//
//    long howFar = timeMilli2 - parseLong(theLocationTime);
//
//    long howFarInMins = ((howFar/1000) / 60);
//
//
//    //String departureTime = getDepartureSchedule(theRoute, direcccc, )
//
//    // Creating date format
//    DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
//
//    // Creating date from milliseconds
//    // using Date() constructor
//    Date result = new Date(parseLong(theLocationTime));
//
//    // Formatting Date according to the
//    // given format
//    System.out.println(simple.format(result));
//
//   // String locationTime = "/Date(1621576798000-0500)/";
//    String kdkd = locationTime.replaceFirst(findNums, regexReplace);
//    System.out.println(schedule);
//
//    return String.valueOf(howFarInMins);
//  }
//
////  private String getVehicleLocation(String secondColumn){
////
////    RestTemplate restTemplate = new RestTemplate();
////    String locationTime = null;
////
////    VehicleLocation[] locations = restTemplate.getForObject("https://svc.metrotransit.org/NexTrip/VehicleLocations/" + parseInt(secondColumn), VehicleLocation[].class);
////    for(VehicleLocation vehicleLocation : locations){
////      locationTime = vehicleLocation.getLocationTime();
////    }
////
////    return locationTime;
////  }
////
////  private String getDirection(String  secondColumn, int direction){
////    RestTemplate restTemplate = new RestTemplate();
////    String location = null;
////
////    Direction[] direction1 =  restTemplate.getForObject("https://svc.metrotransit.org/NexTrip/Stops/" + parseInt(secondColumn) + "/" + direction, Direction[].class);
////    for(Direction direct : direction1){
////      location = direct.getText();
////    }
////
////   return location;
////  }
//
////  private String getDepartureSchedule(String secondColumn, String direction, ){
////
////    // Get departure time http://svc.metrotransit.org/NexTrip/{ROUTE}/{DIRECTION}/{STOP}
////    RestTemplate restTemplate = new RestTemplate();
////    Schedule[] departureTime = restTemplate.getForObject("http://svc.metrotransit.org/NexTrip/{ROUTE}/{DIRECTION}/{STOP}\n", Schedule[].class);
////  }

}
