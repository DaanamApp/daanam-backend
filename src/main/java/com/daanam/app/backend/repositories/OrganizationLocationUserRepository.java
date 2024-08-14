package com.daanam.app.backend.repositories;

import com.daanam.app.backend.models.OrganizationLocationUser;
import com.daanam.app.backend.repositories.projections.UserView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrganizationLocationUserRepository extends JpaRepository<OrganizationLocationUser, UUID> {
  List<UserView> findAllByUserId(UUID userId);
}
