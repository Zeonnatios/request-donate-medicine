package com.healthcare.requestdonatemedicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping(value = "/register")
  public String getRegisterPage() {
    return "register";
  }

}
