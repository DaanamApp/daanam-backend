package com.daanam.app.backend.models;

import com.daanam.app.backend.models.enums.DonationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "donations")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Donation {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private DonationStatus donationStatus;
  @ManyToOne
  private Lead lead;
  @ManyToOne
  private User user;
  @ManyToOne
  private LeadPurpose leadPurpose;
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
