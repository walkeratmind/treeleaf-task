package com.treeleaf.vehicle.tracker.service;

import com.treeleaf.vehicle.tracker.entity.VehicleEntity;
import com.treeleaf.vehicle.tracker.exception.VehicleException;
import com.treeleaf.vehicle.tracker.exception.VehicleNotFoundException;
import com.treeleaf.vehicle.tracker.model.dto.VehicleDTO;
import com.treeleaf.vehicle.tracker.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Transactional
    public Integer createVehicle(VehicleDTO vehicleRequest) {
        VehicleEntity vehicleEntity = new VehicleEntity();

        if (vehicleRepository.existsByNumber(vehicleRequest.getNumber()))  {
            throw new VehicleException("Vehicle already exists with vehcile number: " + vehicleRequest.getNumber());
        }

        vehicleEntity.setNumber(vehicleRequest.getNumber());
        vehicleEntity.setBrand(vehicleRequest.getBrand());
        vehicleEntity.setType(vehicleRequest.getType());

        return vehicleRepository.save(vehicleEntity).getId();
    }

    @Transactional(readOnly = true)
    public List<VehicleEntity> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public VehicleEntity getVehicleById(Integer id) {
        Optional<VehicleEntity> vehicleEntity = vehicleRepository.findById(id);

        return vehicleEntity.orElseThrow(VehicleNotFoundException::new);
    }

    public Integer updateVehicle(Integer vehicleId, VehicleDTO vehicleRequest) {
        Optional<VehicleEntity> vehicle = vehicleRepository.findById(vehicleId);

        VehicleEntity vehicleEntity = vehicle.orElseThrow(VehicleNotFoundException::new);

        vehicleEntity.setNumber(vehicleRequest.getNumber());
        vehicleEntity.setBrand(vehicleRequest.getBrand());
        vehicleEntity.setType(vehicleRequest.getType());

        return vehicleRepository.save(vehicleEntity).getId();
    }

    @Transactional
    public void deleteVehicle(Integer vehicleId) {
        Optional<VehicleEntity> vehicleEntity = vehicleRepository.findById(vehicleId);

        vehicleEntity.ifPresent(vehicleRepository::delete);
        throw new VehicleNotFoundException();
    }
}
