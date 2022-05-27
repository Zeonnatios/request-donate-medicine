package com.healthcare.requestdonatemedicine.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "medicine")
public class Medicine implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @NotBlank(message = "Invalid Input")
  @Size(min = 4, max = 30, message = "Invalid Input")
  @Column(name = "name", nullable = false, length = 30, unique = true)
  private String name;

  @NotBlank(message = "Invalid Input")
  @Size(min = 4, max = 30, message = "Invalid Input")
  @Column(name = "category", nullable = false, length = 30)
  private String category;

  @NotBlank(message = "Invalid Input")
  @Min(value = 4, message = "Invalid Input")
  @Max(value = 9999, message = "Invalid Input")
  @Column(name = "quantity", nullable = false)
  private Integer quantity;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
