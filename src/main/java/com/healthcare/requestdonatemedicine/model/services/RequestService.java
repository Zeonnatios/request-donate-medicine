package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Request;
import java.util.List;

public interface RequestService {

  public void addRequest(Request request);

  public List<Request> getAllRequests();

}