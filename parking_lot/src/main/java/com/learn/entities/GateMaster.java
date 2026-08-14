package com.learn.entities;

import com.learn.enums.GateType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "GATE_MASTER")
public class GateMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PARKING_LOT_MASTER_ID")
    private ParkingLotMaster parkingLot;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private GateType type;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
}
