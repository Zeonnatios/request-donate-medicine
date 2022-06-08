package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Request;
import com.healthcare.requestdonatemedicine.model.repository.RequestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImp implements RequestService {

  @Autowired
  private RequestRepository requestRepository;

  @Override
  public void addRequest(Request request) {
    requestRepository.save(request);
  }

  @Override
  public List<Request> getAllRequests() {
    return requestRepository.findAll();
  }
}
