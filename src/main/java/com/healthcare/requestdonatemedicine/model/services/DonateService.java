package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Donate;
import com.healthcare.requestdonatemedicine.model.entities.User;
import java.util.List;

public interface DonateService {

  public void addDonation(Donate donate, User user);

  public List<Donate> getAllDonations();

  public List<Donate> getAllDonationsByUser(String name);

}
