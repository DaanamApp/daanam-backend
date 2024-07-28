package com.daanam.app.backend.repositories;

import com.daanam.app.backend.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
