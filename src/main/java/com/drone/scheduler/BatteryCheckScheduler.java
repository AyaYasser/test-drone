package com.drone.scheduler;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.drone.repository.BatteryAuditRepository;
import com.drone.repository.DroneRepository;
import com.drone.repository.entity.BatteryAuditEntity;

@Component
public class BatteryCheckScheduler {
  private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BatteryCheckScheduler.class);
  @Autowired DroneRepository droneRepository;
  @Autowired BatteryAuditRepository batteryAuditRepository;
  @Scheduled(cron = "${cron.expression}")
  public void scheduler(){
    logger.info("**** Scheduler start ***");
    UUID jobExecutionId=UUID.randomUUID();
    droneRepository.findAll().forEach(e->{
      BatteryAuditEntity batteryAudit=new BatteryAuditEntity();
      batteryAudit.setBatteryCapacityPercentage(e.getBatteryCapacityPercentage());
      batteryAudit.setDroneId(e.getId());
      batteryAudit.setJobExecutionId(jobExecutionId);
      batteryAudit.setCreated_at(new Date());
      batteryAuditRepository.save(batteryAudit);
    });
    logger.info("**** Scheduler end ***");
  }

}
