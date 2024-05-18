package com.intelligent.logistics.repositories;

import com.intelligent.logistics.models.TrackingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackingInfoRepository extends JpaRepository<TrackingInfo, Long> {
    List<TrackingInfo> findByDeliveryOrderId(Long deliveryOrderId);
}
