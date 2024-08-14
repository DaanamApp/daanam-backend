package com.daanam.app.backend.models;

import com.daanam.app.backend.models.enums.DonationType;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Static table to capture various purpose for lead generation
 */
@Entity
@Table(name = "lead_purposes")
@Data
public class LeadPurpose {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  private String purpose;
  private String displayName;
  private String description;
  private DonationType donationType;
}
