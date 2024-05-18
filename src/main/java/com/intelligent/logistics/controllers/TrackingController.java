package com.intelligent.logistics.controllers;

import com.intelligent.logistics.models.TrackingInfo;
import com.intelligent.logistics.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracking")
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @PostMapping
    public ResponseEntity<TrackingInfo> saveTrackingInfo(@RequestBody TrackingInfo trackingInfo) {
        return ResponseEntity.ok(trackingService.saveTrackingInfo(trackingInfo));
    }

    @GetMapping("/{deliveryOrderId}")
    public ResponseEntity<List<TrackingInfo>> getTrackingInfo(@PathVariable Long deliveryOrderId) {
        return ResponseEntity.ok(trackingService.getTrackingInfoByDeliveryOrderId(deliveryOrderId));
    }
}
