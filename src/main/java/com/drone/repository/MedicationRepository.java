package com.drone.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.drone.repository.entity.MedicationEntity;

public interface MedicationRepository extends JpaRepository<MedicationEntity, UUID> {
}
