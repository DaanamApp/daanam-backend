package com.daanam.app.backend.services.businesslogic.location;

import com.daanam.app.backend.dtos.LocationDto;
import com.daanam.app.backend.models.Location;
import com.daanam.app.backend.models.OrganizationLocationUser;
import com.daanam.app.backend.repositories.LocationRepository;
import com.daanam.app.backend.repositories.OrganizationLocationUserRepository;
import com.daanam.app.backend.repositories.OrganizationRepository;
import com.daanam.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
  private final LocationRepository locationRepository;
  private final OrganizationLocationUserRepository organizationLocationUserRepository;
  private final OrganizationRepository organizationRepository;
  private final UserRepository userRepository;

  /**
   * @param locationDto
   * @return
   */
  @Override
  @Transactional
  public Location saveLocation(LocationDto locationDto) {
    try{
      Location location = new Location();
      location.setPincode(locationDto.getPincode());
      location.setState(locationDto.getState());
      location.setCountry(locationDto.getCountry());
      location.setCity(locationDto.getCity());
      location.setAddressLine2(locationDto.getAddressLine2());
      location.setAddressLine1(locationDto.getAddressLine1());
      location.setBranchName(locationDto.getBranchName());

      Location createdLocation = locationRepository.save(location);

      if(locationDto.getOrganizationId() != null || locationDto.getUserId() != null) {
        OrganizationLocationUser organizationLocationUser = new OrganizationLocationUser();

        if(locationDto.getOrganizationId() != null) organizationLocationUser.setOrganization(organizationRepository.findById(locationDto.getOrganizationId()).orElseThrow());
        if(locationDto.getUserId() != null) organizationLocationUser.setUser(userRepository.findById(locationDto.getUserId()).orElseThrow());

        organizationLocationUserRepository.save(organizationLocationUser);
      }
      return createdLocation;
    } catch (RuntimeException e) {
      log.error(e.getMessage(), e.getCause());
      return null;
    }
  }
}
