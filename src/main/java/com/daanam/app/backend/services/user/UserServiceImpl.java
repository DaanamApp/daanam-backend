package com.daanam.app.backend.services.user;

import com.daanam.app.backend.dtos.LocationDto;
import com.daanam.app.backend.dtos.UserDto;
import com.daanam.app.backend.models.Location;
import com.daanam.app.backend.models.User;
import com.daanam.app.backend.repositories.LocationRepository;
import com.daanam.app.backend.repositories.OrganizationRepository;
import com.daanam.app.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final OrganizationRepository organizationRepository;
  private final LocationRepository locationRepository;

  @Override
  @Transactional
  public boolean registration(UserDto userDto) {
    try {
      Location location = new Location();
      location.setBranchName(userDto.getLocationDto().getBranchName());
      location.setAddressLine1(userDto.getLocationDto().getAddressLine1());
      location.setAddressLine2(userDto.getLocationDto().getAddressLine2());
      location.setCity(userDto.getLocationDto().getCity());
      location.setState(userDto.getLocationDto().getState());
      location.setCountry(userDto.getLocationDto().getCountry());
      location.setPincode(userDto.getLocationDto().getPincode());
      Location persistedLocation = locationRepository.save(location);

      User user = new User();
      user.setFirstName(userDto.getFirstName());
      user.setLastName(userDto.getLastName());
      user.setEmail(userDto.getEmail());
      user.setPhone(userDto.getPhone());
      user.setRole(userDto.getRole());
      user.setLocation(persistedLocation);
      if (userDto.getOrganizationId() != null)
        user.setOrganization(organizationRepository.findById(userDto.getOrganizationId()).orElseThrow());
      if (userDto.getOrganizationLocationId() != null)
        user.setOrganizationLocation(locationRepository.findById(userDto.getOrganizationLocationId()).orElseThrow());
      User persistedUser = userRepository.save(user);

      return true;
    } catch (Exception e) {
      log.error(e.getMessage(), e.getCause());
      return false;
    }
  }

  @Override
  public UserDto fetchUserById(UUID userId) {
    try{
      User fetchedUser = userRepository.findById(userId).orElseThrow();

      LocationDto locationDto = new LocationDto();
      locationDto.setBranchName(fetchedUser.getLocation().getBranchName());
      locationDto.setPincode(fetchedUser.getLocation().getPincode());
      locationDto.setAddressLine1(fetchedUser.getLocation().getAddressLine1());
      locationDto.setAddressLine2(fetchedUser.getLocation().getAddressLine2());
      locationDto.setCity(fetchedUser.getLocation().getCity());
      locationDto.setState(fetchedUser.getLocation().getState());
      locationDto.setCountry(fetchedUser.getLocation().getCountry());

      UserDto userDto = new UserDto();
      userDto.setEmail(fetchedUser.getEmail());
      userDto.setPhone(fetchedUser.getPhone());
      userDto.setRole(fetchedUser.getRole());
      userDto.setFirstName(fetchedUser.getFirstName());
      userDto.setLastName(fetchedUser.getLastName());
      userDto.setLocationDto(locationDto);

      return userDto;
    } catch (Exception e) {
      log.error(e.getMessage(), e.getCause());
      return null;
    }
  }
}
