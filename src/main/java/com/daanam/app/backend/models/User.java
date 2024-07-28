package com.daanam.app.backend.models;

import com.daanam.app.backend.services.cryptography.CryptographicConverter;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
  private String email;
  @OneToOne(optional = false)
  private Location location;
  @OneToOne
  private Organization organization;
  @OneToOne
  private Location organizationLocation;
  private Role role;
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
