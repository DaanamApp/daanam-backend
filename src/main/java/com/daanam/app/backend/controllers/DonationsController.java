package com.daanam.app.backend.controllers;

import com.daanam.app.backend.dtos.DonationDto;
import com.daanam.app.backend.models.Donation;
import com.daanam.app.backend.services.businesslogic.donation.DonationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/donation")
@Slf4j
public class DonationsController {
  @Autowired
  private DonationService donationService;

  @PostMapping("/{leadId}/payment")
  public ResponseEntity<Donation> create(@PathVariable UUID leadId, @RequestBody DonationDto donationDto, @RequestHeader HttpHeaders httpHeaders) {
    Donation createdDonation = donationService.savePaymentDonation(leadId, donationDto);
    return new ResponseEntity<>(createdDonation, HttpStatus.CREATED);
  }

  // TODO: Step initiate payment processing
}
