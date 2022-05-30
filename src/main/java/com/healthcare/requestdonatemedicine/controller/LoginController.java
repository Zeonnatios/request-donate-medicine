package com.healthcare.requestdonatemedicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  @GetMapping(value = "/login")
  public String getLoginPage() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String login(@RequestParam String username, @RequestParam String password) {
    System.out.println(username + password);
    return "/login";
  }

  @GetMapping(value="/logout")
  public String logout() {
    return "redirect:/login";
  }

}
