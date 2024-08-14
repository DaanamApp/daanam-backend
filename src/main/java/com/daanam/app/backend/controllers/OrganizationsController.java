package com.daanam.app.backend.controllers;

import com.daanam.app.backend.models.Organization;
import com.daanam.app.backend.services.businesslogic.organization.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizations")
@Slf4j
public class OrganizationsController {
  @Autowired
  private OrganizationService organizationService;

  @PostMapping
  public ResponseEntity<Organization> create(@RequestBody Organization organization) {
    return new ResponseEntity<>(organizationService.saveOrganization(organization), HttpStatus.CREATED);
  }

}
