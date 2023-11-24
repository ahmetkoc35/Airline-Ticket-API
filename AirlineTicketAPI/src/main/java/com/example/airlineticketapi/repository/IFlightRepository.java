package com.example.airlineticketapi.repository;

import com.example.airlineticketapi.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long>
{
    @Query("from Flight where flight_date = :date")
    Page<Flight> findFlightsByFlight_date(LocalDate date, Pageable pageable);


    @Query("from Flight where flight_date > :date")
    Page<Flight> findFlightsByFlight_dateAfter(LocalDate date, Pageable pageable);

    @Query("from Flight where flight_date < :date")
    Page<Flight> findFlightsByFlight_dateBefore(LocalDate date, Pageable pageable);

    @Query("from Flight where flight_date between :start and :end")
    Page<Flight> findFlightsByFlight_dateBetween(LocalDate start, LocalDate end, Pageable pageable);

    @Query("from Flight where from_location = :from and to_location = :to")
    Page<Flight> findFlightsByFrom_locationAndTo_location(String from, String to, Pageable pageable);

    @Query("from Flight where (flight_date between :start and :end) and (from_location = :from and to_location = :to)")
    Page<Flight> findFlightsByFrom_locationAndTo_locationAndFlight_dateBetween(LocalDate start, LocalDate end,
                                                                               String from, String to, Pageable pageable);

    @Query("from Flight where price < :price and (flight_date between :start and :end) and (from_location = :from and to_location = :to)")
    Page<Flight> findFlightsByPriceLessThanAndFlight_dateBetweenAndFrom_locationAndTo_location(double price, LocalDate start,
                                                                                               LocalDate end, String from, String to,
                                                                                               Pageable pageable);

    @Query("from Flight where (price >= :price1 and price <= :price2) and (flight_date between :start and :end) and (from_location = :from and to_location = :to)")
    Page<Flight> findFlightsByPriceBetweenThanAndFlight_dateBetweenAndFrom_locationAndTo_location(double price1, double price2, LocalDate start,
                                                                                                  LocalDate end, String from, String to,
                                                                                                  Pageable pageable);
}
