package com.daanam.app.backend.services.businesslogic.donation;

import com.daanam.app.backend.dtos.DonationDto;
import com.daanam.app.backend.models.PaymentDonation;
import com.daanam.app.backend.models.enums.DonationStatus;
import com.daanam.app.backend.repositories.DonationRepository;
import com.daanam.app.backend.repositories.LeadRepository;
import com.daanam.app.backend.repositories.OrganizationLocationUserRepository;
import com.daanam.app.backend.repositories.UserRepository;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class DonationServiceImpl implements DonationService {
  private final DonationRepository donationRepository;
  private final LeadRepository leadRepository;
  private final UserRepository userRepository;
  private final OrganizationLocationUserRepository organizationLocationUserRepository;

  /**
   * @param leadId
   * @param donationDto
   * @return donation
   */
  @Override
  public PaymentDonation savePaymentDonation(UUID leadId, DonationDto donationDto) {
    try{
      PaymentDonation donation = new PaymentDonation();
      donation.setLead(leadRepository.findById(donationDto.getLeadId()).orElseThrow());
      donation.setUser(userRepository.findById(donationDto.getUserId()).orElseThrow());
      donation.setOrganizationLocationUser(organizationLocationUserRepository.findById(donationDto.getOrganizationLocationUserId()).orElseThrow());
      donation.setDonationAmount(donationDto.getDonationAmount());
      donation.setPaymentMode(donationDto.getPaymentMode());
      donation.setDonationStatus(DonationStatus.INITIATED);

      return donation;
    } catch (PersistenceException e) {
      log.error(e.getMessage(), e);
      throw new PersistenceException("Failed while persisting donation", e.getCause());
    } catch (RuntimeException e) {
      log.error(e.getMessage(), e);
      throw new RuntimeException("Failure during donation processing", e.getCause());
    }
  }
}
