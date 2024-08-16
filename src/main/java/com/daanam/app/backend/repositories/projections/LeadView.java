package com.daanam.app.backend.repositories.projections;

import com.daanam.app.backend.models.LeadPurpose;
import com.daanam.app.backend.models.enums.LeadStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface LeadView {
  String getDescription();
  LeadStatus getLeadStatus();
  LeadPurpose getLeadPurpose();
  BigDecimal getRequiredValue();
  LocalDateTime getCreatedAt();
  LocalDateTime getUpdatedAt();
  int getTotalDonation();
  double getFulfilledDonation();
}
