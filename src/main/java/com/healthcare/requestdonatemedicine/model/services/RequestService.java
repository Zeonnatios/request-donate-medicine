package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.Request;
import com.healthcare.requestdonatemedicine.model.entities.User;
import java.util.List;

public interface RequestService {

  public void addRequest(Request request);

  public List<Request> getAllRequests();

  public List<Request> getAllRequestsByUser(String name);

  public boolean validateRequest(String category, String name, Integer quantity);

  public void addRequest(String category, String name, Integer quantity, User user);

}
