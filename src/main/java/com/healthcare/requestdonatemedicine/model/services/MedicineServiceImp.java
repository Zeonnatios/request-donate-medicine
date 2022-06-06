package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Medicine;
import com.healthcare.requestdonatemedicine.model.repository.MedicineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicineServiceImp implements MedicineService {

  @Autowired
  private MedicineRepository medicineRepository;

  @Override
  public void saveMedicine(Medicine medicine) {
    medicineRepository.save(medicine);
  }

  @Override
  public List<Medicine> getAllMedicines() {
    return medicineRepository.findAll();
  }
}
