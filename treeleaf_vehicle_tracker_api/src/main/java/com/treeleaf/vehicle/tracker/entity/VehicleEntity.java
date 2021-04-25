package com.treeleaf.vehicle.tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "VehicleEntity")
@Table(name="Vehicle")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId")
    private Integer id;

    @Column(name = "VehicleNumber", nullable = false, unique = true)
    private String number;

    @Column(name="VehicleType", nullable = false)
    private String type;

    @Column(name="VehicleBrand", nullable = false)
    private String brand;
}
