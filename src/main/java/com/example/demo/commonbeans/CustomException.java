package com.example.demo.commonbeans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

public class CustomException extends Exception {

  private static final Logger logger = LogManager.getLogger(CustomException.class);

  public CustomException(Class clazz, Exception ex, String errorMessage, String customMessage) {
    super(errorMessage.concat("@").concat(ex != null && ex.getMessage() != null ? ex.getMessage() : "").concat("@").concat(customMessage != null ? customMessage : ""));
    String className = clazz != null ? StringUtils.capitalize(clazz.getSimpleName()) : "";
    logger.error(className + "---EXCEPTION OCCURRED WHILE----------ERROR MESSAGE-----" + errorMessage + "---CUSTOM-MESSAGE---" + customMessage + "---EXCEPTION DETAILS---" + ex);
  }
}
