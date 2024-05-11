package com.intelligent.logistics.controllers;

import com.intelligent.logistics.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @Autowired
    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    // Endpoint to fetch performance analytics data
    @GetMapping
    public ResponseEntity<?> getPerformanceAnalytics() {
        try {
            // Call the service method to fetch performance analytics data
            Object analyticsData = analyticsService.fetchPerformanceAnalytics();

            // Return the fetched data as ResponseEntity
            return new ResponseEntity<>(analyticsData, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return appropriate response
            return new ResponseEntity<>("Error fetching performance analytics: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
