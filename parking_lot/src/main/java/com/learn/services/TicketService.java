package com.learn.services;

import com.learn.dtos.EnterRequestDto;
import com.learn.dtos.TicketResponseDto;
import com.learn.entities.TicketMaster;
import org.apache.coyote.BadRequestException;

public interface TicketService {

    TicketResponseDto enter(EnterRequestDto enterRequestDto) throws Exception;

    Long exit(Long ticketId, Long exitGateId) throws BadRequestException;
}
