package com.intelligent.logistics.controllers;

import com.intelligent.logistics.models.Driver;
import com.intelligent.logistics.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        try {
            List<Driver> drivers = driverService.getAllDrivers();
            return ResponseEntity.ok(drivers);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        try {
            Driver driver = driverService.getDriverById(id);
            return driver != null ? ResponseEntity.ok(driver) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        try {
            Driver savedDriver = driverService.saveDriver(driver);
            return ResponseEntity.ok(savedDriver);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver updatedDriver) {
        try {
            Driver driver = driverService.updateDriver(id, updatedDriver);
            return driver != null ? ResponseEntity.ok(driver) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        try {
            driverService.deleteDriver(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(500).body(null);
        }
    }
}
