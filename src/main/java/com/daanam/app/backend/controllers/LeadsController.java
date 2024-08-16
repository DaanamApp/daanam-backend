package com.daanam.app.backend.controllers;

import com.daanam.app.backend.dtos.LeadDto;
import com.daanam.app.backend.models.Lead;
import com.daanam.app.backend.repositories.projections.LeadView;
import com.daanam.app.backend.services.businesslogic.lead.LeadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping
  public ResponseEntity<List<LeadView>> showLeads(@RequestParam int limit, @RequestParam int offset) {
    List<LeadView> leads = leadService.fetchPaginatedLeads(limit, offset);
    return new ResponseEntity<>(leads, HttpStatus.OK);
  }
}
