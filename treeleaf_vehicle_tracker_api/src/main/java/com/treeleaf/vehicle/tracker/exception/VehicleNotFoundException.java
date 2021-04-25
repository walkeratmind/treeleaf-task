package com.treeleaf.vehicle.tracker.exception;

import com.treeleaf.vehicle.tracker.constants.VehicleConstants;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException() {
        super(VehicleConstants.VEHICLE_NOT_FOUND);
    }

    public VehicleNotFoundException(String msg) {
        super(msg);
    }
}
