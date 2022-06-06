package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Medicine;
import java.util.List;

public interface MedicineService {

  public void saveMedicine(Medicine medicine);

  public List<Medicine> getAllMedicines();

}
