package com.daanam.app.backend.services.businesslogic.lead;

import com.daanam.app.backend.dtos.LeadDto;
import com.daanam.app.backend.models.Lead;

public interface LeadService {
  Lead saveLead(LeadDto leadDto);
}
