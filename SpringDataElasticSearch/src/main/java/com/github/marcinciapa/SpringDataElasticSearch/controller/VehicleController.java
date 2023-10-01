package com.github.marcinciapa.SpringDataElasticSearch.controller;

import com.github.marcinciapa.SpringDataElasticSearch.document.Vehicle;
import com.github.marcinciapa.SpringDataElasticSearch.search.SearchRequestDTO;
import com.github.marcinciapa.SpringDataElasticSearch.service.VehicleService;
import com.github.marcinciapa.SpringDataElasticSearch.service.helper.VehicleDummyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    private final VehicleService service;
    private final VehicleDummyDataService dummyDataService;

    @Autowired
    public VehicleController(VehicleService service, VehicleDummyDataService dummyDataService) {
        this.service = service;
        this.dummyDataService = dummyDataService;
    }

    @PostMapping
    public void save(@RequestBody final Vehicle vehicle) {
        service.index(vehicle);
    }

    @PostMapping("/insertdummydata")
    public void insertDummyData() {
        dummyDataService.insertDummyData();
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
            @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) {

        return service.getAllVehiclesCreatedSince(date);
    }

    @PostMapping("/searchcreatedsince/{date}")
    public List<Vehicle> searchCreatedSince(
            @RequestBody final SearchRequestDTO dto,
            @PathVariable
            @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) {

        return service.searchCreatedSince(dto, date);
    }


}
