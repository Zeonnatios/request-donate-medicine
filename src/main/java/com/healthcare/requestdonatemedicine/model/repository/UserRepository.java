package com.healthcare.requestdonatemedicine.model.repository;

import com.healthcare.requestdonatemedicine.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  User findByUsername(String username);
}
