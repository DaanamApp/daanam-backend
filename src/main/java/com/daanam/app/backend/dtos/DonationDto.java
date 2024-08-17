package com.daanam.app.backend.dtos;


import com.daanam.app.backend.models.enums.DonationStatus;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class DonationDto {
  private UUID leadId;
  private UUID userId;
  private UUID organizationLocationUserId;
  private BigDecimal donationAmount;
  private String paymentMode;
  private long nos;
  private String description;
}
