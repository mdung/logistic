package com.intelligent.logistics.repositories;
import com.intelligent.logistics.models.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<DeliveryOrder, Long> {
//    Optional<List<DeliveryOrder>> findDeliveryOrdersById(Long id); // Renamed method
//    @Query("SELECT DISTINCT d.deliveryOrders FROM DeliveryOrder d")
//    List<List<DeliveryOrder>> findAllRoutes();
}
