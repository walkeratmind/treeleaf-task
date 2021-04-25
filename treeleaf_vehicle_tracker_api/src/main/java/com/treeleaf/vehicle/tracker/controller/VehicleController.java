package com.treeleaf.vehicle.tracker.controller;

import com.treeleaf.vehicle.tracker.constants.VehicleConstants;
import com.treeleaf.vehicle.tracker.entity.VehicleEntity;
import com.treeleaf.vehicle.tracker.model.dto.VehicleDTO;
import com.treeleaf.vehicle.tracker.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<String> createVehicle(@RequestBody VehicleDTO vehicleRequestDTO) {
        Integer id = vehicleService.createVehicle(vehicleRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(VehicleConstants.VEHICLE_CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehicleEntity>> getVehicles() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicles());
    }

    @GetMapping
    public ResponseEntity<VehicleEntity> getVehicleById(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicleById(id));
    }

    @PutMapping
    public ResponseEntity<String> updateVehicle(@RequestParam("id") Integer id, @RequestBody VehicleDTO vehicleRequestDTO) {
        vehicleService.updateVehicle(id, vehicleRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(VehicleConstants.VEHICLE_UPDATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteVehicle(@RequestParam("id") Integer id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(VehicleConstants.VEHICLE_DELETED);
    }
}
