package com.example.airlineticketapi.service;

import com.example.airlineticketapi.dto.*;
import com.example.airlineticketapi.model.Flight;
import com.example.airlineticketapi.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FlightService
{
    private final IFlightRepository flightRepository;

    @Value("${page.default-size}")
    private int defaultPageSize;

    @Autowired
    public FlightService(IFlightRepository flightRepository)
    {
        this.flightRepository = flightRepository;
    }

    public FlightDTO saveFlight(FlightSaveDTO flightSaveDTO)
    {
        try
        {
            Flight flight = new Flight(flightSaveDTO.flight_date, flightSaveDTO.from_location, flightSaveDTO.to_location,
                    flightSaveDTO.seat_count, flightSaveDTO.price);

            Flight savedFlight = flightRepository.save(flight);

            return new FlightDTO("Flight created successfully!", savedFlight.flight_id);
        } catch (Exception ex)
        {
            return new FlightDTO("Flight cannot created!", -1);
        }
    }

    public FlightResponseDTO findFlightsByFlightDateBetween(LocalDate start, LocalDate end, int page)
    {
        Pageable pageable = PageRequest.of(page - 1, defaultPageSize);

        Page<Flight> list = flightRepository.findFlightsByFlight_dateBetween(start, end, pageable);

        return new FlightResponseDTO(page, list.getTotalPages(), list.stream().toList());
    }

    public FlightResponseDTO findAllFlights(int page)
    {
        Pageable pageable = PageRequest.of(page - 1, defaultPageSize);

        Page<Flight> list = flightRepository.findAll(pageable);

        return new FlightResponseDTO(page, list.getTotalPages(), list.stream().toList());
    }


    public FlightResponseDTO findFlightsByFromAndToLocation(String from, String to, int page)
    {
        Pageable pageable = PageRequest.of(page - 1, defaultPageSize);

        Page<Flight> list = flightRepository.findFlightsByFrom_locationAndTo_location(from, to, pageable);

        return new FlightResponseDTO(page, list.getTotalPages(), list.stream().toList());
    }


    public FlightResponseDTO findFlightsByFromAndToLocationAndDateBetween(FlightDateAndLocationQueryDTO dto)
    {
        Pageable pageable = PageRequest.of(dto.page - 1, defaultPageSize);

        Page<Flight> list = flightRepository.findFlightsByFrom_locationAndTo_locationAndFlight_dateBetween(dto.start_date, dto.end_date,
                dto.from_location, dto.to_location, pageable);

        return new FlightResponseDTO(dto.page, list.getTotalPages(), list.stream().toList());
    }

    public FlightResponseDTO findFlightsByPriceLessThanAndFlightDateBetweenAndFromLocationAndToLocation(FlightDateAndLocationAndMaxPriceQueryDTO dto)
    {
        Pageable pageable = PageRequest.of(dto.page - 1, defaultPageSize);

        Page<Flight> list = flightRepository.findFlightsByPriceLessThanAndFlight_dateBetweenAndFrom_locationAndTo_location(dto.max_price,
                dto.start_date, dto.end_date, dto.from_location, dto.to_location, pageable);

        return new FlightResponseDTO(dto.page, list.getTotalPages(), list.stream().toList());
    }


    public FlightResponseDTO findFlightsByPriceBetweenAndFlightDateBetweenAndFromLocationAndToLocation(FlightQueryDTO dto)
    {
        Pageable pageable = PageRequest.of(dto.page - 1, defaultPageSize);

        Page<Flight> list = flightRepository.findFlightsByPriceBetweenThanAndFlight_dateBetweenAndFrom_locationAndTo_location(dto.min_price,
                dto.max_price, dto.start_date, dto.end_date, dto.from_location, dto.to_location, pageable);

        return new FlightResponseDTO(dto.page, list.getTotalPages(), list.stream().toList());
    }

    public FlightDTO saveFlightV2(FlightSaveDTOv2 flightSaveDTO)
    {
        FlightSaveDTO dto = new FlightSaveDTO(flightSaveDTO.flight_date, flightSaveDTO.from_location, flightSaveDTO.to_location,
                85, flightSaveDTO.price);

        return saveFlight(dto);
    }
}