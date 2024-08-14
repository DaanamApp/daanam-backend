package com.daanam.app.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "organizations_locations_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationLocationUser {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn
  @JsonBackReference
  private Organization organization;
  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn
  @JsonBackReference
  private Location location;
  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn
  @JsonBackReference
  private User user;
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
