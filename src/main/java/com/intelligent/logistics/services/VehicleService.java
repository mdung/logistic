package com.intelligent.logistics.services;

import com.intelligent.logistics.models.Vehicle;
import com.intelligent.logistics.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Method to retrieve all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Method to retrieve a vehicle by its ID
    public Vehicle getVehicleById(Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        return vehicleOptional.orElse(null);
    }

    // Method to create a new vehicle
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Method to update an existing vehicle
    public Vehicle updateVehicle(Long id, Vehicle newVehicleData) {
        Optional<Vehicle> existingVehicleOptional = vehicleRepository.findById(id);
        if (existingVehicleOptional.isPresent()) {
            Vehicle existingVehicle = existingVehicleOptional.get();
            // Update properties of existingVehicle with newVehicleData
            // For simplicity, let's assume all properties are updated
            existingVehicle.setRegistrationNumber(newVehicleData.getRegistrationNumber());
            // Update other properties as needed
            return vehicleRepository.save(existingVehicle);
        } else {
            return null; // Vehicle with given ID not found
        }
    }

    // Method to delete a vehicle by its ID
    public boolean deleteVehicle(Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        if (vehicleOptional.isPresent()) {
            vehicleRepository.deleteById(id);
            return true;
        } else {
            return false; // Vehicle with given ID not found
        }
    }

    public boolean updateVehicleLocation(Long id, String location) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();
            vehicle.setLocation(location);
            vehicleRepository.save(vehicle);
            return true;
        } else {
            return false;
        }
    }
}