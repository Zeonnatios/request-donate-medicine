package com.healthcare.requestdonatemedicine.model.repository;

import com.healthcare.requestdonatemedicine.model.entities.Donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateRepository extends JpaRepository<Donate, Integer> {

}
