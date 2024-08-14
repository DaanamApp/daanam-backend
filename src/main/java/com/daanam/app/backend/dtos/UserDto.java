package com.daanam.app.backend.dtos;

import com.daanam.app.backend.models.enums.UserCategory;
import com.daanam.app.backend.models.enums.UserRole;
import com.daanam.app.backend.repositories.projections.UserView;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDto {
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private LocationDto locationDto;
  private UUID organizationId;
  private UUID locationId;
  private UserRole userRole;
  private UserCategory userCategory;
  private List<UserView> organizationLocation;
}
