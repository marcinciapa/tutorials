package com.github.marcinciapa.SpringDataElasticSearch.controller;

import com.github.marcinciapa.SpringDataElasticSearch.document.Vehicle;
import com.github.marcinciapa.SpringDataElasticSearch.search.SearchRequestDTO;
import com.github.marcinciapa.SpringDataElasticSearch.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    private final VehicleService service;

    @Autowired
    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final Vehicle vehicle) {
        service.index(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable final String id) {
        return service.getById(id);
    }

    @PostMapping("/search")
    public List<Vehicle> search(@RequestBody final SearchRequestDTO dto) {
        return service.search(dto);
    }

    @GetMapping("/search/{date}")
    public List<Vehicle> getAllVehiclesCreatedSince(
            @PathVariable
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            final Date date) {
        return service.getAllVehiclesCreatedSince(date);
    }
}
