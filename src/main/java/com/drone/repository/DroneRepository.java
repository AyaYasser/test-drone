package com.drone.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.drone.common.dto.DroneStatus;
import com.drone.repository.entity.DroneEntity;


@Transactional
public interface DroneRepository extends JpaRepository<DroneEntity, UUID> {
  @Modifying
  @Query("update DroneEntity d set d.status= :status where d.id= :id")
  void updateDroneStatusById(@Param("status")DroneStatus status,@Param("id") UUID uuid);
  List<DroneEntity> findAllByStatus(DroneStatus status);
}
