package com.treeleaf.vehicle.tracker.repositories;

import com.treeleaf.vehicle.tracker.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationEntity, Integer> {
}
