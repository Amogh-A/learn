package com.learn.dtos;

import com.learn.entities.TicketMaster;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {
    Boolean parkingAvailable;
    String reason;
    TicketMaster ticketMaster;
}
