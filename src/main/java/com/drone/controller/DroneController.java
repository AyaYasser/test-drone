package com.drone.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import com.drone.common.dto.DroneResource;
import com.drone.service.DroneService;

@RestController
@RequestMapping(value = "/drone")
public class DroneController {

  @Autowired DroneService droneService;

  @ApiOperation(value = "Register a Drone ") @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully registered"),
      @ApiResponse(code = 404, message = "Registration failed ") }) @PostMapping(value = "/register") public ResponseEntity<String> register(
      @RequestBody @Valid DroneResource droneResource) {
    String droneId = droneService.regiserDrone(droneResource);
    return new ResponseEntity<String>(droneId, HttpStatus.OK);
  }

  @ApiOperation(value = "Load a Drone with Mediacations ,DroneId should be a UUID ") @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully loaded"),
      @ApiResponse(code = 404, message = "Loading failed ") }) @PutMapping(value = "load/{droneId}") public void loadDrone(
      @PathVariable(value = "droneId") @Valid UUID droneId) {
    droneService.loadDrone(droneId);
  }

  @ApiOperation(value = "Checking loaded medication items for a given dron ") @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully loaded"),
      @ApiResponse(code = 404, message = "Drone not found ") }) @GetMapping(value = "check-medication/{droneId}") public ResponseEntity<DroneResource> checkMedForAdrone(
      @PathVariable(value = "droneId") @Valid UUID droneId) {
    DroneResource resource = droneService.getDroneDetails(droneId);
    if (resource != null)
      return new ResponseEntity<>(resource, HttpStatus.OK);
    else
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }
  @ApiOperation(value = "Checking available drones for loadin ") @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success getting available drones to be loaded"),
      @ApiResponse(code = 404, message = "There are no drones to be loaded ") })
  @GetMapping(value = "available-load")
  public ResponseEntity<List<DroneResource>> getAvailableDronesForLoading() {
    List<DroneResource> resource = droneService.getAvailableDronesToLoad();
    if (resource != null)
      return new ResponseEntity<>(resource, HttpStatus.OK);
    else
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }
}
