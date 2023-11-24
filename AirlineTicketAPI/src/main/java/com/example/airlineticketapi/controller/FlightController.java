package com.example.airlineticketapi.controller;

import com.example.airlineticketapi.dto.*;
import com.example.airlineticketapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/flight/{version}")
public class FlightController
{
    private final FlightService flightService;


    @Autowired
    public FlightController(FlightService flightService)
    {
        this.flightService = flightService;
    }


    @GetMapping("/byDateBetween")
    public FlightResponseDTO findFlightsByFlightDateBetween(@RequestParam("start") LocalDate startDate,
                                                            @RequestParam("end") LocalDate endDate,
                                                            @RequestParam("page") int page,
                                                            @PathVariable String version)
    {
        return flightService.findFlightsByFlightDateBetween(startDate, endDate, page);
    }

    @GetMapping("/all")
    public FlightResponseDTO findAllFlights(@RequestParam("page") int page, @PathVariable String version)
    {
        return flightService.findAllFlights(page);
    }

    @GetMapping("/byLocation")
    public FlightResponseDTO findFlightsByFromAndToLocation(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("page") int page, @PathVariable String version)
    {
        return flightService.findFlightsByFromAndToLocation(from, to, page);
    }

    @PostMapping("/byLocationAndDateBetween")
    public FlightResponseDTO findFlightsByFromAndToLocationAndDateBetween(@RequestBody FlightDateAndLocationQueryDTO dto, @PathVariable String version)
    {
        return flightService.findFlightsByFromAndToLocationAndDateBetween(dto);
    }

    @PostMapping("/byMaxPriceAndDateBetweenAndLocation")
    public FlightResponseDTO findFlightsByPriceLessThanAndFlightDateBetweenAndFromLocationAndToLocation(@RequestBody FlightDateAndLocationAndMaxPriceQueryDTO dto, @PathVariable String version)
    {
        return flightService.findFlightsByPriceLessThanAndFlightDateBetweenAndFromLocationAndToLocation(dto);
    }

    @PostMapping("/byPriceBetweenAndDateBetweenAndLocation")
    public FlightResponseDTO findFlightsByPriceBetweenAndFlightDateBetweenAndFromLocationAndToLocation(@RequestBody FlightQueryDTO dto, @PathVariable String version)
    {

        return flightService.findFlightsByPriceBetweenAndFlightDateBetweenAndFromLocationAndToLocation(dto);
    }


    @PostMapping("/save")
    @PreAuthorize("isAuthenticated()")
    public FlightDTO saveFlight(@RequestBody FlightSaveDTO flightSaveDTO, @PathVariable String version,
                                @RequestBody(required = false) FlightSaveDTOv2 flightSaveDTOv2)
    {
        if (version.equals("v2")) // Default Seat count is 85
            return flightService.saveFlightV2(flightSaveDTOv2);

        else return flightService.saveFlight(flightSaveDTO); // Seat count is given by user
    }
}
