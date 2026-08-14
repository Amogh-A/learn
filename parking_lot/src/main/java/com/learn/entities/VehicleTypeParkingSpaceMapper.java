package com.learn.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "VEHICLE_TYPE_PARKING_SPACE_MAPPER")
public class VehicleTypeParkingSpaceMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VEHICLE_TYPE_ID")
    private VehicleTypeMaster vehicleType;

    @ManyToOne
    @JoinColumn(name = "PARKING_SPACE_META_ID")
    private ParkingSpaceMeta parkingSpaceMeta;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
}
