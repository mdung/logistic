package com.intelligent.logistics.repositories;

import com.intelligent.logistics.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // Add custom query methods if needed
}
