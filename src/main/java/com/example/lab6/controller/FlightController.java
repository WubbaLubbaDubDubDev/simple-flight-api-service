package com.example.lab6.controller;

import com.example.lab6.model.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    // Статичне поле (імітація бази даних)
    private static final List<Flight> flights = new ArrayList<>();

    // Заповнення списку одразу при ініціалізації класу (static блок)
    static {
        flights.add(new Flight(
                1L,
                "Kyiv",
                "Lviv",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                1500.0,
                "PS101",
                LocalDateTime.now()
        ));
        flights.add(new Flight(
                2L,
                "Odesa",
                "Warsaw",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(2),
                3500.0,
                "LOT777",
                LocalDateTime.now()
        ));
    }

    // GET /flights, повертає список, Status 200 (за замовчуванням)
    @GetMapping
    public List<Flight> getAllFlights() {
        return flights;
    }

    // GET /flights/{id}, повертає рейс за id, Status 200
    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flights.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // POST /flights, створює рейс, Status 201 (Created)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Явно вказуємо статус 201
    public Flight createFlight(@RequestBody Flight flight) {
        flight.setCreation_date(LocalDateTime.now());
        flights.add(flight);
        return flight;
    }

    // DELETE /flights/{id}, видаляє рейс, Status 204 (No Content)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Явно вказуємо статус 204
    public void deleteFlight(@PathVariable Long id) {
        flights.removeIf(f -> f.getId().equals(id));
    }
}