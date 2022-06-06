package com.healthcare.requestdonatemedicine.controller;

import com.healthcare.requestdonatemedicine.model.entities.User;
import com.healthcare.requestdonatemedicine.model.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/register")
  public String getRegisterPage(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "register";
  }

  @PostMapping(value = "/register")
  public String postRegisterPage(@Valid User user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "register";
    }
    System.out.println(user);
    userService.saveUser(user);

    return "register";
  }

  @GetMapping(value = "/userhome")
  public String getUserHomePage() {
    return "user/home";
  }

  @GetMapping(value = "/userRequestMedicine")
  public String getUserRequestMedicinePage() {
    return "user/requestMedicine";
  }

  @GetMapping(value = "/userDonateMedicine")
  public String getUserDonateMedicinePage() {
    return "user/donateMedicine";
  }

  @GetMapping(value = "/userViewDonateMedicine")
  public String getUserViewDonateMedicinePage() {
    return "user/viewDonateMedicine";
  }

}
