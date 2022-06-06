package com.healthcare.requestdonatemedicine.model.repository;

import com.healthcare.requestdonatemedicine.model.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

}
