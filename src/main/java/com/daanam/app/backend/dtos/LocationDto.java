package com.daanam.app.backend.dtos;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class LocationDto {
  private UUID organizationId;
  private UUID userId;
  private String branchName;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String country;
  private int pincode;
}
