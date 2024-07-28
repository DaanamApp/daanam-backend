package com.daanam.app.backend.services.user;

import com.daanam.app.backend.dtos.UserDto;

import java.util.UUID;

public interface UserService {
  boolean registration(UserDto userDto);

  UserDto fetchUserById(UUID userId);
}
