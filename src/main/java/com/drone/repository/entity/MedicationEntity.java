package com.drone.repository.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "MEDICATION")
@Entity
@Data
@NoArgsConstructor
public class MedicationEntity {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  @Column(name = "name", columnDefinition = "VARCHAR(255)")
  private String name;

  @Column(name = "weight", columnDefinition = "double")
  private double weight;

  @Column(name = "code", columnDefinition = "VARCHAR(255)")
  private String code;

  @Column(name = "image_url", columnDefinition = "VARCHAR(255)")
  private String imageUrl;



}
