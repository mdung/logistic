package com.intelligent.logistics.controllers;

import com.intelligent.logistics.models.TrackingInfo;
import com.intelligent.logistics.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracking")
public class TrackingInfoController {

    private final TrackingService trackingService;

    @Autowired
    public TrackingInfoController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/{deliveryOrderId}")
    public ResponseEntity<List<TrackingInfo>> getTrackingInfo(@PathVariable Long deliveryOrderId) {
        List<TrackingInfo> trackingInfos = trackingService.getTrackingInfoByDeliveryOrderId(deliveryOrderId);
        return ResponseEntity.ok(trackingInfos);
    }

    @PostMapping
    public ResponseEntity<TrackingInfo> saveTrackingInfo(@RequestBody TrackingInfo trackingInfo) {
        TrackingInfo savedTrackingInfo = trackingService.saveTrackingInfo(trackingInfo);
        return ResponseEntity.ok(savedTrackingInfo);
    }
}
