package com.daanam.app.backend.models;

import com.daanam.app.backend.services.cryptography.CryptographicConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Entity
@Table(name = "locations")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String branchName;
  @Convert(converter = CryptographicConverter.class)
  private String addressLine1;
  @Convert(converter = CryptographicConverter.class)
  private String addressLine2;
  private String city;
  private String state;
  private String country;
  private int pincode;
}
