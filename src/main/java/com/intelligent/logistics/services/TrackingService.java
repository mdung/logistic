package com.intelligent.logistics.services;

import com.intelligent.logistics.models.TrackingInfo;
import com.intelligent.logistics.repositories.TrackingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingService {

    @Autowired
    private TrackingInfoRepository trackingInfoRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public TrackingInfo saveTrackingInfo(TrackingInfo trackingInfo) {
        TrackingInfo savedInfo = trackingInfoRepository.save(trackingInfo);
        messagingTemplate.convertAndSend("/topic/tracking", savedInfo);
        return savedInfo;
    }

    public List<TrackingInfo> getTrackingInfoByDeliveryOrderId(Long deliveryOrderId) {
        return trackingInfoRepository.findByDeliveryOrderId(deliveryOrderId);
    }
}
