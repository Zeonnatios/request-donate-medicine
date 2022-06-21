package com.healthcare.requestdonatemedicine.controller;

import com.healthcare.requestdonatemedicine.model.entities.User;
import com.healthcare.requestdonatemedicine.model.services.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/login")
  public String getLoginPage() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String login(Model model, HttpServletRequest request, @RequestParam String username,
      @RequestParam String password) {

    boolean isValidLogin = userService.validateUser(username, password);

    if (isValidLogin) {
      HttpSession session = request.getSession();
      session.setAttribute("user", userService.findUserByUsername(username));
      if (username.equals("Admin")) {
        return "redirect:/adminhome";
      } else {
        return "redirect:/userhome";
      }
    } else {
      model.addAttribute("errorMessage", "Invalid Input");
      return "/login";
    }

  }

  @GetMapping(value = "/logout")
  public String logout() {
    return "redirect:/login";
  }

  void setSessionUserAttributes(User user, HttpSession session) {
    session.setAttribute("user", user);
  }

}
