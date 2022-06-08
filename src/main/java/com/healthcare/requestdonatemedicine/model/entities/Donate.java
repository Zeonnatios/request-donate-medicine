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
  @Column(name = "category", nullable = false, length = 30)
  private String category;

  @NotBlank(message = "Invalid Input")
  @Size(min = 4, max = 30, message = "Invalid Input")
  @Column(name = "name", nullable = false, length = 30)
  private String name;

  @NotNull(message = "Invalid Input")
  @Min(value = 1, message = "Invalid Input")
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
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

  @Override
  public String toString() {
    return "Donate{" +
        "id=" + id +
        ", category='" + category + '\'' +
        ", name='" + name + '\'' +
        ", quantity=" + quantity +
        ", username='" + username + '\'' +
        ", address='" + address + '\'' +
        ", requestedDate=" + requestedDate +
        '}';
  }
}
