package com.intelligent.logistics.services;

import com.intelligent.logistics.dto.TrackingInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TrackingSimulationService {

    private static final Logger logger = LoggerFactory.getLogger(TrackingSimulationService.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final Random random = new Random();
    private double latitude = 40.712776;
    private double longitude = -74.005974;

    @Scheduled(fixedRate = 5000) // Update every 5 seconds
    public void sendTrackingUpdates() {
        latitude += (random.nextDouble() - 0.5) / 1000;
        longitude += (random.nextDouble() - 0.5) / 1000;

        TrackingInfoDTO trackingInfo = new TrackingInfoDTO();
        trackingInfo.setLatitude(latitude);
        trackingInfo.setLongitude(longitude);
        trackingInfo.setTimestamp(LocalDateTime.now());
        trackingInfo.setDeliveryOrderId(1L); // Replace with actual delivery order ID

        logger.info("Sending tracking update: {}", trackingInfo);

        messagingTemplate.convertAndSend("/topic/tracking", trackingInfo);
    }
}
