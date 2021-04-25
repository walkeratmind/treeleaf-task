package com.treeleaf.vehicle.tracker.repositories;

import com.treeleaf.vehicle.tracker.entity.VehicleEntity;
import com.treeleaf.vehicle.tracker.model.dto.VehicleDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<VehicleEntity, Integer> {

    List<VehicleEntity> findAll();
    boolean existsByNumber(String number);
}
