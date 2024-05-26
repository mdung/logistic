package com.intelligent.logistics.repositories;

import com.intelligent.logistics.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
