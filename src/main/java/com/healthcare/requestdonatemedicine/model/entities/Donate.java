package com.healthcare.requestdonatemedicine.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "donate")
public class Donate implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @NotBlank(message = "Invalid Input")
  @Size(min = 4, max = 30, message = "Invalid Input")
  @Column(name = "medCategory", nullable = false, length = 30)
  private String medCategory;

  @NotBlank(message = "Invalid Input")
  @Size(min = 4, max = 30, message = "Invalid Input")
  @Column(name = "medName", nullable = false, length = 30)
  private String medName;

  @NotNull(message = "Invalid Input")
  @Min(value = 1, message = "Invalid Input")
  @Column(name = "medQuantity", nullable = false)
  private Integer medQuantity;

  @NotBlank(message = "Invalid Input")
  @Size(min = 3, max = 30, message = "Invalid Input")
  @Column(name = "username", nullable = false, length = 30)
  private String username;

  @NotBlank(message = "Invalid Input")
  @Size(min = 6, max = 30, message = "Invalid Input")
  @Column(name = "address", nullable = false, length = 30)
  private String address;

  @Temporal(TemporalType.DATE)
  @Column(name = "requestedDate", nullable = false)
  private Date requestedDate;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getMedCategory() {
    return medCategory;
  }

  public void setMedCategory(String medCategory) {
    this.medCategory = medCategory;
  }

  public String getMedName() {
    return medName;
  }

  public void setMedName(String medName) {
    this.medName = medName;
  }

  public Integer getMedQuantity() {
    return medQuantity;
  }

  public void setMedQuantity(Integer medQuantity) {
    this.medQuantity = medQuantity;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getRequestedDate() {
    return requestedDate;
  }

  public void setRequestedDate(Date requestedDate) {
    this.requestedDate = requestedDate;
  }
}
