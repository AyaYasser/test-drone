package com.drone.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DroneModel {
  LIGHT_WEIGHT(0),
  MIDDLE_WEIGHT(1),
  CRUISER_WEIGHT(2),
  HEAVY_WEIGHT(31)
  ;

  private int modelId;
}
