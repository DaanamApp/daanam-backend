package com.daanam.app.backend.repositories;

import com.daanam.app.backend.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DonationRepository extends JpaRepository<Donation, UUID> {
}
