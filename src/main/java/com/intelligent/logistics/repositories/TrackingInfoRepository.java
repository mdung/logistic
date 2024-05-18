package com.intelligent.logistics.repositories;

import com.intelligent.logistics.models.TrackingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingInfoRepository extends JpaRepository<TrackingInfo, Long> {
    List<TrackingInfo> findByDeliveryOrderId(Long deliveryOrderId);
}
