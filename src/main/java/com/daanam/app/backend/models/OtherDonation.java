package com.daanam.app.backend.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
public class OtherDonation extends Donation {
  private long nos;
  private String description;
}
