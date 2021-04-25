package com.treeleaf.vehicle.tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "CameraEntity")
@Table(name="Camera")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class CameraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CameraId")
    private Integer id;

    @Column(name = "CameraModel", nullable = false)
    private String model;

    @Column(name="LocationId", insertable = false, updatable = false)
    private Integer locationId;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LocationId", referencedColumnName = "LocationId", nullable = false)
    private LocationEntity location;
}
