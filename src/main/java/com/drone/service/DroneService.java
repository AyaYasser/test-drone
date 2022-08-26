package com.drone.service;

import java.util.List;
import java.util.UUID;

import com.drone.common.dto.DroneModel;
import com.drone.common.dto.DroneResource;

public interface DroneService {
  String regiserDrone(DroneResource droneResource);
  void loadDrone(UUID droneId);

  DroneResource getDroneDetails(UUID droneId);
  List<DroneResource> getAvailableDronesToLoad();


}
