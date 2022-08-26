package com.drone.common.mapper;

import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import com.drone.common.dto.DroneModel;
import com.drone.common.dto.DroneResource;
import com.drone.common.dto.DroneStatus;
import com.drone.repository.entity.DroneEntity;

@Mapper(imports = {UUID.class,DroneModel.class, DroneStatus.class })
public interface DroneMapper {
  DroneMapper INSTANCE = Mappers.getMapper(DroneMapper.class);

  @Mappings({
      @Mapping(target = "id",expression ="java(UUID.randomUUID())" ),
      @Mapping(target = "status",expression = "java(DroneStatus.IDLE)"),
      @Mapping(target = "model", qualifiedByName = "getDroneModel")
  })
  DroneEntity mapModelToEntity(DroneResource droneResource);
  DroneResource mapEntityToModel(DroneEntity droneEntity);

 List<DroneResource> mapListEntityToListModel(List<DroneEntity> droneEntities);



  @Named("getDroneModel")
  @BeforeMapping
  default DroneModel getDroneModel(String model) {
    return DroneModel.valueOf(model.toUpperCase());
  }

}
