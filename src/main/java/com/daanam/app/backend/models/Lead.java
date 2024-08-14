package com.daanam.app.backend.models;

import com.daanam.app.backend.models.enums.LeadStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "leads")
@Data
public class Lead {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @ManyToOne
  @JoinColumn
  private Organization organization;
  private String description;
  private LeadStatus status;
  @ManyToOne
  @JoinColumn
  private LeadPurpose leadPurpose;
  @Column(nullable = false, precision = 12, scale = 2)
  @Digits(integer = 10, fraction = 2)
  private BigDecimal requiredValue;
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
