package com.daanam.app.backend.dtos;

import com.daanam.app.backend.models.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private LocationDto locationDto;
  private UUID organizationId;
  private UUID organizationLocationId;
  private Role role;
}
