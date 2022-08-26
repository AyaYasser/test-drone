package com.drone.repository.entity;

import java.util.Date;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "BATTERY_AUDIT")
@Entity
@Data
@NoArgsConstructor
public class BatteryAuditEntity {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  @Column(name = "job_execution_id", columnDefinition = "VARCHAR(255)")
  private UUID jobExecutionId;

  @Column(name = "drone_id", columnDefinition = "VARCHAR(255)")
  private UUID droneId;

  @Column(name = "battery_capacity", columnDefinition = "double")
  private double batteryCapacityPercentage;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at")
  private Date created_at;

}
