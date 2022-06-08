package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Donate;
import java.util.List;

public interface DonateService {

  public void addDonation(Donate donate);

  public List<Donate> getAllDonations();

}
