package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.User;

public interface  UserService {

  public void saveUser(User user);

  public User findUserByUsername(String username);

  boolean validateUser(String username, String password);

}
