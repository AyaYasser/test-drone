package com.drone.common.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.Set;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.naming.ldap.PagedResultsControl;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import com.drone.common.helper.EnumValidator;

@Data
public class DroneResource {
  private static final String SERIAL_NO_MSG="Serial No length shouldn't be less than 1 and/or greater than 100";
  private static final String MODEL_MSG="Drone model should be one of the below values"
      + " LIGHT_WEIGHT\n" + "  MIDDLE_WEIGHT\n" + "  CRUISER_WEIGHT\n" + "  HEAVY_WEIGHT";

  private static final String WEIGHT="Drone weight shouldn't exceed 500 gm";
  private static final String BATTERY="Drone battery percentage shouldn't exceed 100";


  @ApiModelProperty(notes = SERIAL_NO_MSG, example = "A-1", required = true)
  @NotBlank(message = "Serial No should have a value")
  @Size(min=1,max=100,message = SERIAL_NO_MSG)
  private String serialNo;

  @ApiModelProperty(notes = MODEL_MSG, example = "LIGHT_WEIGHT", required = true)
  @EnumValidator(targetClassType = DroneModel.class,message = MODEL_MSG)
  private String model;

  @ApiModelProperty(notes = WEIGHT, example = "200", required = true)
  @Max(value = 500,message = WEIGHT)
  private double weight;

  @ApiModelProperty(notes = BATTERY, example = "80", required = true)
  @Max(value = 100,message = BATTERY)
  private double batteryCapacityPercentage;

  private Set<MedicationResource> medications;


}
