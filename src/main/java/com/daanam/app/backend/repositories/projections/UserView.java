package com.daanam.app.backend.repositories.projections;

import com.daanam.app.backend.models.Organization;
import com.daanam.app.backend.models.Location;

public interface UserView {
  Organization getOrganization();
  Location getLocation();
}
