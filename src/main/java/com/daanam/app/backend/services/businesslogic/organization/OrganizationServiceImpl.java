package com.daanam.app.backend.services.businesslogic.organization;

import com.daanam.app.backend.models.Organization;
import com.daanam.app.backend.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService{
  private static final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);
  private final OrganizationRepository organizationRepository;
  /**
   * @param organization
   * @return
   */
  @Override
  public Organization saveOrganization(Organization organization) {
    try {
      return organizationRepository.save(organization);
    } catch (Exception e) {
      log.error(e.getMessage(), e.getCause());
      return null;
    }
  }
}
