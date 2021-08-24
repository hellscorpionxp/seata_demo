package com.tony.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private static final String SUCCESS = "SUCCESS";
  private static final String FAIL = "FAIL";
  @Autowired
  private JdbcTemplate accountJdbcTemplate;
  private static final Random R = new Random();

  @PostMapping(value = "/account", produces = "application/json")
  public String account(String userId, Double money) {
    if (R.nextBoolean()) {
      throw new RuntimeException("This is mock Exception, HaHaHa!");
    }
    int result = accountJdbcTemplate.update("update account_tbl set money = money - ? where user_id = ?", money,
        userId);
    if (result == 1) {
      return SUCCESS;
    }
    return FAIL;
  }

}
