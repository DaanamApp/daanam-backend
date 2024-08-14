package com.daanam.app.backend.controllers;

import com.daanam.app.backend.dtos.UserDto;
import com.daanam.app.backend.services.businesslogic.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {
  @Autowired
  private UserService userService;

  @PostMapping(path = "/registration")
  public ResponseEntity<String> create(@RequestBody UserDto userDto){
    if (userService.registration(userDto)) return new ResponseEntity<>("Success", HttpStatus.CREATED);
    return new ResponseEntity<>("Failed!", HttpStatus.NOT_ACCEPTABLE);
  }

  @GetMapping(path = "/{userId}")
  public ResponseEntity<UserDto> show(@PathVariable UUID userId) {
    return new ResponseEntity<>(userService.fetchUserById(userId), HttpStatus.OK);
  }

}
