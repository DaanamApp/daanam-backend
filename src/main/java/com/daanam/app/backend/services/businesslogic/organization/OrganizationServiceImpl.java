package com.daanam.app.backend.services.businesslogic.organization;

import com.daanam.app.backend.models.Organization;
import com.daanam.app.backend.repositories.OrganizationRepository;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService{
  private final OrganizationRepository organizationRepository;
  /**
   * @param organization
   * @return organization
   */
  @Override
  public Organization saveOrganization(Organization organization) {
    try {
      return organizationRepository.save(organization);
    } catch (PersistenceException e) {
      log.error(e.getMessage(), e);
      throw new PersistenceException("Organization persistence failed", e.getCause());
    } catch (RuntimeException e) {
      log.error(e.getMessage(), e);
      throw new RuntimeException("Failure during persisting organization", e.getCause());
    }
  }
}
