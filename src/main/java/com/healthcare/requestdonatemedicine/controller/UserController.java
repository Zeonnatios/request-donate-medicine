package com.healthcare.requestdonatemedicine.controller;

import com.healthcare.requestdonatemedicine.model.entities.Donate;
import com.healthcare.requestdonatemedicine.model.entities.Medicine;
import com.healthcare.requestdonatemedicine.model.entities.Request;
import com.healthcare.requestdonatemedicine.model.entities.User;
import com.healthcare.requestdonatemedicine.model.services.DonateService;
import com.healthcare.requestdonatemedicine.model.services.MedicineService;
import com.healthcare.requestdonatemedicine.model.services.RequestService;
import com.healthcare.requestdonatemedicine.model.services.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private DonateService donateService;

  @Autowired
  private RequestService requestService;

  @Autowired
  private MedicineService medicineService;

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

    userService.saveUser(user);
    return "redirect:/login";
  }

  @GetMapping(value = "/userhome")
  public String getUserHomePage(Model model, HttpServletRequest request) {
    User user = (User) request.getSession().getAttribute("user");
    model.addAttribute("requestList", requestService.getAllRequestsByUser(user.getUsername()));
    return "user/home";
  }

  @GetMapping(value = "/userRequestMedicine")
  public String getUserRequestMedicinePage(Model model) {
    model.addAttribute("medicineList", medicineService.getAllMedicines());
    model.addAttribute("medicineCategories", medicineService.getAllCategories());
    return "user/requestMedicine";
  }

  @PostMapping(value = "/userRequestMedicine")
  public String postUserRequestMedicinePage(Model model, HttpServletRequest request,
      @RequestParam String category, @RequestParam String name, @RequestParam int quantity) {
    boolean isValidRequest = requestService.validateRequest(category, name, quantity);

    if (isValidRequest) {
      User user = (User) request.getSession().getAttribute("user");
      requestService.addRequest(category, name, quantity, user);
      return "redirect:/userhome";
    } else {
      model.addAttribute("errorMessage", "Invalid Input");
      return "userRequestMedicine";
    }
  }

  @GetMapping(value = "/userDonateMedicine")
  public String getUserDonateMedicinePage(Model model) {
    Donate donate = new Donate();
    model.addAttribute("donate", donate);
    return "user/donateMedicine";
  }

  @PostMapping(value = "/userDonateMedicine")
  public String postUserDonateMedicinePage(@Valid Donate donate, BindingResult bindingResult,
      HttpServletRequest request) {
    if (bindingResult.hasErrors()) {
      return "user/donateMedicine";
    }
    User user = (User) request.getSession().getAttribute("user");
    donateService.addDonation(donate, user);
    return "redirect:/userViewDonateMedicine";
  }

  @GetMapping(value = "/userViewDonateMedicine")
  public String getUserViewDonateMedicinePage(Model model, HttpServletRequest request) {
    User user = (User) request.getSession().getAttribute("user");
    model.addAttribute("donationsList", donateService.getAllDonationsByUser(user.getUsername()));

    return "user/viewDonateMedicine";
  }

}
