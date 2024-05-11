package com.intelligent.logistics.repositories;

import com.intelligent.logistics.models.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {
    // Add custom query methods if needed
}
