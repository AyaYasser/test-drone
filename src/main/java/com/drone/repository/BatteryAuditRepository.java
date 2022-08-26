package com.drone.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.drone.repository.entity.BatteryAuditEntity;

public interface BatteryAuditRepository extends JpaRepository<BatteryAuditEntity, UUID> {
}
