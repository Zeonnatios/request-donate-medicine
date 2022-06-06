package com.healthcare.requestdonatemedicine.model.services;

import com.healthcare.requestdonatemedicine.model.entities.User;
import com.healthcare.requestdonatemedicine.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User findUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public boolean validateUser(String username, String password) {
    User user = userRepository.findByUsername(username);

    return (username.equals(user.getUsername()) && password.equals(user.getPassword()));
  }

}
