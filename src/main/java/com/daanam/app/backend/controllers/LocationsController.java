package com.daanam.app.backend.controllers;


import com.daanam.app.backend.dtos.LocationDto;
import com.daanam.app.backend.models.Location;
import com.daanam.app.backend.services.businesslogic.location.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
@Slf4j
public class LocationsController {
  @Autowired
  private LocationService locationService;

  @PostMapping
  public ResponseEntity<Location> create(@RequestBody LocationDto locationDto) {
    return new ResponseEntity<>(locationService.saveLocation(locationDto), HttpStatus.CREATED);
  }
}
