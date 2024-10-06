package com.example.flightmail.mapper;

import com.example.flightmail.dto.FlightMailDto;
import com.example.flightmail.entity.FlightMail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface FlightMailMapper {
    FlightMailDto toDto(FlightMail flightMail);
    FlightMail toEntity(FlightMailDto flightMailDto);
}
