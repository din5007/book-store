package com.bnpp.bookstore.utils;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

@Component("queryUtil")
public class QueryCondition {

  public boolean checkNull(String field) {
    return StringUtils.isBlank(field);
  }
}
