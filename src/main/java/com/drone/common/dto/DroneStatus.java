package com.drone.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DroneStatus {
  IDLE(0), LOADING(1), LOADED(2), DELIVERING(3), DELIVERED(4), RETURNING(5);

  private int statusId;

  }
