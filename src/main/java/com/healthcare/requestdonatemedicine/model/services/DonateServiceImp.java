package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Donate;
import com.healthcare.requestdonatemedicine.model.entities.User;
import com.healthcare.requestdonatemedicine.model.repository.DonateRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonateServiceImp implements DonateService {

  @Autowired
  private DonateRepository donateRepository;

  @Override
  public void addDonation(Donate donate, User user) {
    donate.setRequestedDate(new Date());
    donate.setUsername(user.getUsername());
    donate.setAddress(user.getAddress());
    donateRepository.save(donate);
  }

  @Override
  public List<Donate> getAllDonations() {
    return donateRepository.findAll();
  }

  @Override
  public List<Donate> getAllDonationsByUser(String name) {
    return donateRepository.findDonationsByUsername(name);
  }

}
