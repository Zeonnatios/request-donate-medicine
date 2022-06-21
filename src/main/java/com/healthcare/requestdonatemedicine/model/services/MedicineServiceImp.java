package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Medicine;
import com.healthcare.requestdonatemedicine.model.repository.MedicineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImp implements MedicineService {

  @Autowired
  private MedicineRepository medicineRepository;


  @Override
  public Medicine findMedicineIfExists(String name) {
    return medicineRepository.findMedicineIfExists(name);
  }

  @Override
  public void saveMedicine(Medicine medicine) {
    Medicine medicineIsFound = findMedicineIfExists(medicine.getName());
    if (medicineIsFound != null) {
      int medicineAmount = medicineIsFound.getQuantity() + medicine.getQuantity();
      medicineRepository.updateQuantityOfMedicines(medicineAmount, medicineIsFound.getId());
    } else {
      medicineRepository.save(medicine);
    }
  }

  @Override
  public List<String> getAllCategories() {
    return medicineRepository.getAllCategories();
  }

  @Override
  public List<Medicine> getAllMedicines() {
    return medicineRepository.findAll();
  }
}
