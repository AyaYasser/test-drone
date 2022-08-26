package com.drone.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;
import com.drone.common.dto.DroneResource;
import com.drone.common.dto.DroneStatus;
import com.drone.common.mapper.DroneMapper;
import com.drone.repository.DroneRepository;
import com.drone.repository.entity.DroneEntity;

@Service
public class DroneServiceImpl implements DroneService{
  @Autowired DroneRepository droneRepository;

  @Override public String regiserDrone(DroneResource droneResource) {
      DroneEntity entity=droneRepository.save(DroneMapper.INSTANCE.mapModelToEntity(droneResource));
      return entity.getId().toString();
  }

  @Override public void loadDrone(UUID droneId) {
    droneRepository.updateDroneStatusById(DroneStatus.LOADED,droneId);
  }

  @Override public DroneResource getDroneDetails(UUID droneId) {
    Optional<DroneEntity> entity=droneRepository.findById(droneId);
    if(entity.isPresent())
       return DroneMapper.INSTANCE.mapEntityToModel(entity.get());
    else
      return null;
  }

  @Override public List<DroneResource> getAvailableDronesToLoad() {
    List<DroneEntity> entities=droneRepository.findAllByStatus(DroneStatus.IDLE);
    if(entities!=null && !entities.isEmpty())
     return DroneMapper.INSTANCE.mapListEntityToListModel(entities);
    else
      return null;
  }
}
