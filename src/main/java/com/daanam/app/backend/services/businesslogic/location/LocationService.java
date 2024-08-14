package com.daanam.app.backend.services.businesslogic.location;

import com.daanam.app.backend.dtos.LocationDto;
import com.daanam.app.backend.models.Location;

public interface LocationService {
  Location saveLocation(LocationDto locationDto);
}
