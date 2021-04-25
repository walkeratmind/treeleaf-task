package com.treeleaf.vehicle.tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "LocationEntity")
@Table(name="Location")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
    @Column(name = "LocationId")
    private Integer id;

    @Column(name="LocationName", nullable = false, unique = true)
    private String name;

    @Column(name="Latitude", nullable = false, unique = true)
    private Float latitude;

    @Column(name="longitude", nullable = false, unique = true)
    private Float longitude;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "location")
    private Collection<CameraEntity> cameraEntities;

}
