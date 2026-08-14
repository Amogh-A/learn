package com.learn.entities;

import com.learn.enums.OccupancyStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PARKING_SPACE_MASTER")
public class ParkingSpaceMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IDENTIFIER")
    private String identifier;

    @ManyToOne
    @JoinColumn(name = "PARKING_LOT_MASTER_ID")
    public ParkingLotMaster parkingLot;

    @ManyToOne
    @JoinColumn(name = "PARKING_SPACE_META_ID")
    private ParkingSpaceMeta parkingSpaceMeta;

    @ManyToOne
    @JoinColumn(name = "PARKING_FLOOR_MASTER_ID")
    private ParkingFloorMaster parkingFloor;

    @Enumerated(EnumType.STRING)
    @Column(name = "OCCUPANCY_STATUS")
    private OccupancyStatus occupancyStatus;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
}
