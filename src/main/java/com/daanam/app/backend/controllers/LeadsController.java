package com.daanam.app.backend.controllers;

import com.daanam.app.backend.dtos.LeadDto;
import com.daanam.app.backend.models.Lead;
import com.daanam.app.backend.services.businesslogic.lead.LeadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leads")
@Slf4j
public class LeadsController {
  private LeadService leadService;

  @PostMapping
  public ResponseEntity<Lead> create(@RequestBody LeadDto leadDto) {
    Lead lead = leadService.saveLead(leadDto);
    return new ResponseEntity<>(lead, HttpStatus.CREATED);
  }
}
