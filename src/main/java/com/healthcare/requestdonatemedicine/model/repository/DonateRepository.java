package com.healthcare.requestdonatemedicine.model.repository;

import com.healthcare.requestdonatemedicine.model.entities.Donate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateRepository extends JpaRepository<Donate, Integer> {

  public List<Donate> findDonationsByUsername(String name);

}
