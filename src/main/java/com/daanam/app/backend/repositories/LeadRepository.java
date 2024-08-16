package com.daanam.app.backend.repositories;

import com.daanam.app.backend.models.Lead;
import com.daanam.app.backend.repositories.projections.LeadView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeadRepository extends JpaRepository<Lead, UUID> {
  @Query(value = "SELECT l.description, l.status, l.donationType, l.requiredValue, l.createdAt, l.updatedAt, COUNT(d.id) AS totalDonation, " +
          "CASE " +
          "WHEN l.donationType = 0 THEN ((l.requiredValue / d.donationAmount) * 100 ) " +
          "WHEN l.donationType = 1 THEN ((l.donationAmount / d.nos) * 100) " +
          "ELSE 0 " +
          "END AS fulfilledDonation " +
          "FROM lead AS l " +
          "INNER JOIN donation AS d ON d.leadId = l.id " +
          "WHERE l.id IN (SELECT le.id FROM lead AS le LIMIT :limit OFFSET :offset) " +
          "GROUP BY l.id", nativeQuery = true
  )
  Optional<List<LeadView>> findAllLeadsWithDonationCountAndFulfilledByLimitAndOffset(@Param("limit") int limit, @Param("offset") int offset);
}
