package com.daanam.app.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class PaymentDonation extends Donation{
  @Column(nullable = false, precision = 12, scale = 2)
  @Digits(integer = 10, fraction = 2)
  private BigDecimal donationAmount;
  private String paymentMode;
}
