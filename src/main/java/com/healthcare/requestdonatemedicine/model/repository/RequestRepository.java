package com.healthcare.requestdonatemedicine.model.repository;

import com.healthcare.requestdonatemedicine.model.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
