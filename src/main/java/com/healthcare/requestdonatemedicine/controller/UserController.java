package com.healthcare.requestdonatemedicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping(value = "/register")
  public String getRegisterPage() {
    return "register";
  }

  @GetMapping(value="/userhome")
  public String getUserHomePage() { return "user/home"; }

  @GetMapping(value="/userRequestMedicine")
  public String getUserRequestMedicinePage() { return "user/requestMedicine"; }

  @GetMapping(value="/userDonateMedicine")
  public String getUserDonateMedicinePage() { return "user/donateMedicine"; }

  @GetMapping(value="/userViewDonateMedicine")
  public String getUserViewDonateMedicinePage() { return "user/viewDonateMedicine"; }

}
