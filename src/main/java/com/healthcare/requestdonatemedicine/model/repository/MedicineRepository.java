package com.healthcare.requestdonatemedicine.model.repository;

import com.healthcare.requestdonatemedicine.model.entities.Medicine;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

  @Query(value = "SELECT * FROM MEDICINE M WHERE M.NAME = ?1", nativeQuery = true)
  public Medicine findMedicineIfExists(String name);

  @Query(value = "SELECT category FROM MEDICINE group by category", nativeQuery = true)
  public List<String> getAllCategories();

  @Transactional
  @Modifying
  @Query(value = "UPDATE MEDICINE M SET M.quantity = ?1 WHERE M.ID = ?2", nativeQuery = true)
  public void updateQuantityOfMedicines(int quantity, int id);

}
