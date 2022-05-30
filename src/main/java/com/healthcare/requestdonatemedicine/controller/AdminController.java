package com.healthcare.requestdonatemedicine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

  @GetMapping(value = "/adminViewDonations")
  public String getAdminViewDonationsPage() {
    return "admin/viewDonations";
  }

}
