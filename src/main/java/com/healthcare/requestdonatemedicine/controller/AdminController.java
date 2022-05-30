package com.healthcare.requestdonatemedicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

  @GetMapping("/adminhome")
  public String getAdminHomePage() {
    return "admin/home";
  }

  @GetMapping(value = "/adminViewDonations")
  public String getAdminViewDonationsPage() {
    return "admin/viewDonations";
  }

  @GetMapping(value="/addMedicine")
  public String getAdminAddMedicinePage() {
    return "admin/addMedicine";
  }

}
