package com.daanam.app.backend.services.businesslogic.donation;

import com.daanam.app.backend.dtos.DonationDto;
import com.daanam.app.backend.models.Donation;
import com.daanam.app.backend.models.PaymentDonation;

import java.util.UUID;

public interface DonationService {
  PaymentDonation savePaymentDonation(UUID leadId, DonationDto donationDto);
}
