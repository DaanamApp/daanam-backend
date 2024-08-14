package com.daanam.app.backend.services.businesslogic.user;

import com.daanam.app.backend.dtos.UserDto;
import com.daanam.app.backend.models.OrganizationLocationUser;
import com.daanam.app.backend.models.User;
import com.daanam.app.backend.repositories.LocationRepository;
import com.daanam.app.backend.repositories.OrganizationLocationUserRepository;
import com.daanam.app.backend.repositories.OrganizationRepository;
import com.daanam.app.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final OrganizationRepository organizationRepository;
  private final LocationRepository locationRepository;
  private final OrganizationLocationUserRepository organizationLocationUserRepository;

  @Override
  @Transactional
  public boolean registration(UserDto userDto) {
    try {
      User user = new User();
      user.setFirstName(userDto.getFirstName());
      user.setLastName(userDto.getLastName());
      user.setEmail(userDto.getEmail());
      user.setPhone(userDto.getPhone());
      user.setUserRole(userDto.getUserRole());
      user.setUserCategory(userDto.getUserCategory());
      if (userDto.getOrganizationId() != null || userDto.getLocationId() != null) {
        OrganizationLocationUser organizationLocationUser = new OrganizationLocationUser();
        if (userDto.getOrganizationId() != null) organizationLocationUser.setOrganization(organizationRepository.findById(userDto.getOrganizationId()).orElseThrow());
        if (userDto.getLocationId() != null)
          organizationLocationUser.setLocation(locationRepository.findById(userDto.getLocationId()).orElseThrow());
      }
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

      UserDto userDto = new UserDto();
      userDto.setEmail(fetchedUser.getEmail());
      userDto.setPhone(fetchedUser.getPhone());
      userDto.setUserRole(fetchedUser.getUserRole());
      userDto.setFirstName(fetchedUser.getFirstName());
      userDto.setLastName(fetchedUser.getLastName());
      userDto.setUserCategory(fetchedUser.getUserCategory());

      return userDto;
    } catch (Exception e) {
      log.error(e.getMessage(), e.getCause());
      return null;
    }
  }
}
