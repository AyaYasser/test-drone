package com.drone.repository.entity;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import com.drone.common.dto.DroneModel;
import com.drone.common.dto.DroneStatus;

@Table(name = "DRONE")
@Entity
@Data
@NoArgsConstructor
public class DroneEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  @Column(name = "serial_number", columnDefinition = "VARCHAR(255)")
  private String serialNo;

  @Column(name = "model", columnDefinition = "int")
  @Enumerated(EnumType.ORDINAL)
  private DroneModel model;

  @Column(name = "battery_capacity", columnDefinition = "double")
  private double batteryCapacityPercentage;

  @Column(name = "weight", columnDefinition = "double")
  private double weight;

  @Column(name = "status", columnDefinition = "int")
  @Enumerated(EnumType.ORDINAL)
  private DroneStatus status;

  @OneToMany(targetEntity = MedicationEntity.class,cascade = CascadeType.ALL)
  @JoinColumn(name = "DRONE_ID", referencedColumnName = "id")
  private Set<MedicationEntity> medications;


}
