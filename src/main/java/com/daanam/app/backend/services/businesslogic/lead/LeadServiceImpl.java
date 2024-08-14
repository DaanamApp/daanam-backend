package com.daanam.app.backend.services.businesslogic.lead;

import com.daanam.app.backend.dtos.LeadDto;
import com.daanam.app.backend.models.Lead;
import com.daanam.app.backend.models.LeadPurpose;
import com.daanam.app.backend.models.Organization;
import com.daanam.app.backend.models.enums.LeadStatus;
import com.daanam.app.backend.repositories.LeadPurposeRepository;
import com.daanam.app.backend.repositories.LeadRepository;
import com.daanam.app.backend.repositories.OrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeadServiceImpl implements LeadService{
  private final LeadRepository leadRepository;
  private final LeadPurposeRepository leadPurposeRepository;
  private final OrganizationRepository organizationRepository;

  @Override
  public Lead saveLead(LeadDto leadDto) {
    LeadPurpose leadPurpose = leadPurposeRepository.findById(leadDto.getLeadPurposeId()).orElseThrow(EntityNotFoundException::new);
    Organization organization = organizationRepository.findById(leadDto.getOrganizationId()).orElseThrow(EntityNotFoundException::new);

    Lead lead = new Lead();
    lead.setLeadPurpose(leadPurpose);
    lead.setOrganization(organization);
    lead.setDescription(leadDto.getDescription());
    lead.setStatus(LeadStatus.GENERATED);
    lead.setRequiredValue(leadDto.getRequiredValue());

    return leadRepository.save(lead);
  }
}
