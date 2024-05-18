package com.intelligent.logistics.services;

import com.intelligent.logistics.models.TrackingInfo;
import com.intelligent.logistics.repositories.TrackingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingService {

    private final TrackingInfoRepository trackingInfoRepository;

    @Autowired
    public TrackingService(TrackingInfoRepository trackingInfoRepository) {
        this.trackingInfoRepository = trackingInfoRepository;
    }

    public List<TrackingInfo> getTrackingInfoByDeliveryOrderId(Long deliveryOrderId) {
        return trackingInfoRepository.findByDeliveryOrderId(deliveryOrderId);
    }

    public TrackingInfo saveTrackingInfo(TrackingInfo trackingInfo) {
        return trackingInfoRepository.save(trackingInfo);
    }
}
