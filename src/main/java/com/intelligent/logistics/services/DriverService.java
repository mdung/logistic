package com.intelligent.logistics.services;

import com.intelligent.logistics.models.Driver;
import com.intelligent.logistics.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(Long id) {
        Optional<Driver> driver = driverRepository.findById(id);
        return driver.orElse(null);
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Long id, Driver updatedDriver) {
        Optional<Driver> existingDriver = driverRepository.findById(id);
        if (existingDriver.isPresent()) {
            Driver driver = existingDriver.get();
            driver.setName(updatedDriver.getName());
            driver.setLicenseNumber(updatedDriver.getLicenseNumber());
            driver.setAvailable(updatedDriver.isAvailable());
            return driverRepository.save(driver);
        } else {
            return null;
        }
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}
