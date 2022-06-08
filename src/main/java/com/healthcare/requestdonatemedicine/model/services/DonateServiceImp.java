package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Donate;
import com.healthcare.requestdonatemedicine.model.repository.DonateRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonateServiceImp implements DonateService {

  @Autowired
  private DonateRepository donateRepository;

  @Override
  public void addDonation(Donate donate) {
    donateRepository.save(donate);
  }

  @Override
  public List<Donate> getAllDonations() {
    return donateRepository.findAll();
  }
}