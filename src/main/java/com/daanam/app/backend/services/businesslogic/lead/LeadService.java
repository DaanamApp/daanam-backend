package com.daanam.app.backend.services.businesslogic.lead;

import com.daanam.app.backend.dtos.LeadDto;
import com.daanam.app.backend.models.Lead;
import com.daanam.app.backend.repositories.projections.LeadView;

import java.util.List;

public interface LeadService {
  Lead saveLead(LeadDto leadDto);

  List<LeadView> fetchPaginatedLeads(int limit, int offset);
}
