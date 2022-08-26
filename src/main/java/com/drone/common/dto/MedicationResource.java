package com.drone.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class MedicationResource {
  private static final String NAME_REGEX="^[A-Za-z0-9_-]+$";
  private static final String CODE_REGEX="^[A-Z0-9_]+$";
  private static final String URL_REGEX = "((http|https)://)(www.)?"
      + "[a-zA-Z0-9@:%._\\+~#?&//=]"
      + "{2,256}\\.[a-z]"
      + "{2,6}\\b([-a-zA-Z0-9@:%"
      + "._\\+~#?&//=]*)";

  private static final String NAME_ERROR_MSG="Allowed only letters,numbers,- and _";

  private static final String WEIGHT_ERROR_MSG="Please enter the weight";

  private static final String CODE_ERROR_MSG="Allowed only uppercase letters,numbers and _";

  private static final String IMAGE_URL_ERROR_MSG="Please enter a valid URL";

  @ApiModelProperty(notes = NAME_ERROR_MSG, example = "Medication-A_01", required = true)
  @Pattern(regexp = NAME_REGEX,message = NAME_ERROR_MSG)
  private String name;

  @ApiModelProperty(notes = WEIGHT_ERROR_MSG, example = "1", required = true)
  @NotEmpty
  private double weight;

  @ApiModelProperty(notes = CODE_ERROR_MSG, example = "M_1", required = true)
  @Pattern(regexp = CODE_REGEX,message = CODE_ERROR_MSG)
  private String code;

  @ApiModelProperty(notes = IMAGE_URL_ERROR_MSG, example = "http://xyz.com", required = true)
  @Pattern(regexp = URL_REGEX,message = IMAGE_URL_ERROR_MSG)
  private String imageUrl;
}
