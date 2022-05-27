package com.healthcare.requestdonatemedicine.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @NotBlank(message = "Invalid Input")
  @Size(min = 3, max = 30, message = "Invalid Input")
  @Column(name = "username", nullable = false, length = 30, unique = true)
  private String username;

  @NotBlank(message = "Invalid Input")
  @Size(min = 5, max = 30, message = "Invalid Input")
  @Column(name = "password", nullable = false, length = 30)
  private String password;

  @NotBlank(message = "Invalid Input")
  @Min(value = 18, message = "Invalid Input")
  @Max(value = 100, message = "Invalid Input")
  @Column(name = "age", nullable = false)
  private Integer age;

  @NotBlank(message = "Invalid Input")
  @Column(name = "gender", nullable = false)
  private String gender;

  @NotBlank(message = "Invalid Input")
  @Size(min = 6, max = 30, message = "Invalid Input")
  @Column(name = "address", nullable = false, length = 30)
  private String address;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
