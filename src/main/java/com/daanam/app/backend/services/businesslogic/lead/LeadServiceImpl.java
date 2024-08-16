package com.daanam.app.backend.services.businesslogic.lead;

import com.daanam.app.backend.dtos.LeadDto;
import com.daanam.app.backend.models.Lead;
import com.daanam.app.backend.models.LeadPurpose;
import com.daanam.app.backend.models.Organization;
import com.daanam.app.backend.models.enums.LeadStatus;
import com.daanam.app.backend.repositories.LeadPurposeRepository;
import com.daanam.app.backend.repositories.LeadRepository;
import com.daanam.app.backend.repositories.OrganizationRepository;
import com.daanam.app.backend.repositories.projections.LeadView;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeadServiceImpl implements LeadService{
  private final LeadRepository leadRepository;
  private final LeadPurposeRepository leadPurposeRepository;
  private final OrganizationRepository organizationRepository;

  @Override
  public Lead saveLead(LeadDto leadDto) {
    Organization organization = organizationRepository.findById(leadDto.getOrganizationId()).orElseThrow(EntityNotFoundException::new);

    Lead lead = new Lead();
    lead.setDonationType(leadDto.getDonationType());
    lead.setOrganization(organization);
    lead.setDescription(leadDto.getDescription());
    lead.setStatus(LeadStatus.GENERATED);
    lead.setRequiredValue(leadDto.getRequiredValue());

    return leadRepository.save(lead);
  }

  /**
   * @param limit
   * @param offset
   * @return
   */
  @Override
  public List<LeadView> fetchPaginatedLeads(int limit, int offset) {
    try{
      return leadRepository.findAllLeadsWithDonationCountAndFulfilledByLimitAndOffset(limit, offset).orElseThrow(RuntimeException::new);
    } catch (RuntimeException e) {
      log.error(e.getMessage(), e.getCause());
      throw new RuntimeException("Failed to fetch leads record");
    }
  }
}
