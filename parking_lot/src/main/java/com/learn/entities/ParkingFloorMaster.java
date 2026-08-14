package com.learn.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PARKING_FLOOR_MASTER")
public class ParkingFloorMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PARKING_LOT_MASTER_ID")
    private ParkingLotMaster parkingLot;

    @Column(name = "FLOOR_NUMBER")
    private Integer floorNumber;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
}
