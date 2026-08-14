package com.learn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TICKET_MASTER")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PARKING_LOT_MASTER_ID")
    private ParkingLotMaster parkingLot;

    @ManyToOne
    @JoinColumn(name = "ENTRY_GATE_ID")
    private GateMaster entryGate;

    @ManyToOne
    @JoinColumn(name = "EXIT_GATE_ID")
    private GateMaster exitGate;

    @ManyToOne
    @JoinColumn(name = "VEHICLE_TYPE_MASTER_ID")
    private VehicleTypeMaster vehicleType;

    @ManyToOne
    @JoinColumn(name = "PARKING_SPACE_MASTER_ID")
    private ParkingSpaceMaster parkingSpace;

    @Column(name = "VEHICLE_NUMBER")
    private String vehicleNumber;

    @Column(name = "ENTRY_TIME")
    private LocalDateTime entryTime;

    @Column(name = "EXIT_TIME")
    private LocalDateTime exitTime;

    @ManyToOne
    @JoinColumn(name = "TICKET_MASTER_STATUS_ID")
    private TicketMasterStatus ticketStatus;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
}
