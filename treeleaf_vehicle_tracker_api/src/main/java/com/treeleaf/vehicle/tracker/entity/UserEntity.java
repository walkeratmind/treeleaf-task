package com.treeleaf.vehicle.tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "UserEntity")
@Table(name = "User")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column(name = "UserId")
    private Integer id;

    @Column(name="UserName", nullable = false, unique = true)
    private String userName;

    @Column(name="EmailAddress", nullable = false, unique = true)
    private String emailAddress;

    @Column(name = "Password", nullable = false)
    private String password;
}
