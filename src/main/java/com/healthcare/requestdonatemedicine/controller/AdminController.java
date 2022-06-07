package com.healthcare.requestdonatemedicine.controller;

import com.healthcare.requestdonatemedicine.model.entities.Medicine;
import com.healthcare.requestdonatemedicine.model.services.MedicineService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

  @Autowired
  private MedicineService medicineService;

  @GetMapping("/adminhome")
  public String getAdminHomePage(Model model) {
    model.addAttribute("medicineList", medicineService.getAllMedicines());
    return "admin/home";
  }

  @GetMapping(value = "/adminViewDonations")
  public String getAdminViewDonationsPage() {
    return "admin/viewDonations";
  }

  @GetMapping(value = "/addmedicine")
  public String getAdminAddMedicinePage(Model model) {
    Medicine medicine = new Medicine();
    model.addAttribute("medicine", medicine);
    return "admin/addMedicine";
  }

  @PostMapping(value = "/addmedicine")
  public String postAdminAddMedicinePage(@Valid Medicine medicine, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "admin/addMedicine";
    }

    medicineService.saveMedicine(medicine);

    return "rediect:/adminhome";
  }

  @GetMapping(value = "/adminViewRequests")
  public String getAdminViewRequestsPage() {
    return "admin/viewRequests";
  }

}
