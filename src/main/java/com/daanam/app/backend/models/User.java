package com.daanam.app.backend.models;

import com.daanam.app.backend.annotations.Pan;
import com.daanam.app.backend.models.enums.UserCategory;
import com.daanam.app.backend.models.enums.UserRole;
import com.daanam.app.backend.services.cryptography.CryptographicConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String firstName;
  private String lastName;
  @Convert(converter = CryptographicConverter.class)
  private String phone;
  @Convert(converter = CryptographicConverter.class)
  @Email
  private String email;
  @Convert(converter = CryptographicConverter.class)
  @Pan
  private String panNumber;
  @OneToMany
  @JoinColumn
  @JsonManagedReference
  private List<OrganizationLocationUser> organizationsLocationsUsers;
  private UserRole userRole;
  private UserCategory userCategory;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @PrePersist
  public void onCreation() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  public void onUpdation(){
    this.updatedAt = LocalDateTime.now();
  }
}
