package com.daanam.app.backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
public class LeadDto {
  private UUID organizationId;
  private long leadPurposeId;
  private BigDecimal requiredValue;
  private String description;
}
