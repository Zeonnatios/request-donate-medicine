package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Medicine;
import com.healthcare.requestdonatemedicine.model.entities.Request;
import com.healthcare.requestdonatemedicine.model.entities.User;
import com.healthcare.requestdonatemedicine.model.repository.MedicineRepository;
import com.healthcare.requestdonatemedicine.model.repository.RequestRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImp implements RequestService {

  @Autowired
  private RequestRepository requestRepository;

  @Autowired
  private MedicineRepository medicineRepository;

  @Override
  public void addRequest(Request request) {
    requestRepository.save(request);
  }

  @Override
  public List<Request> getAllRequests() {
    return requestRepository.findAll();
  }

  @Override
  public List<Request> getAllRequestsByUser(String name) {
    return requestRepository.findRequestsByUsername(name);
  }

  @Override
  public boolean validateRequest(String category, String name, Integer quantity) {
    Medicine medicine = medicineRepository.findByName(name);

    if (medicine == null) {
      return false;
    }

    return medicine.getCategory().equals(category) && medicine.getName().equals(name) && (
        medicine.getQuantity() > quantity || medicine.getQuantity().equals(quantity));
  }

  @Override
  public void addRequest(String category, String name, Integer quantity, User user) {
    Request request = new Request();
    request.setCategory(category);
    request.setName(name);
    request.setQuantity(quantity);
    request.setUsername(user.getUsername());
    request.setAddress(user.getAddress());
    request.setRequestedDate(new Date());
    requestRepository.save(request);

    Medicine medicineIsFound = medicineRepository.findMedicineIfExists(name);
    if (medicineIsFound != null) {
      int medicineAmount = medicineIsFound.getQuantity() - quantity;
      medicineRepository.updateQuantityOfMedicines(medicineAmount, medicineIsFound.getId());
    }
  }
}
