package com.intelligent.logistics.controllers;

import com.intelligent.logistics.models.DeliveryOrder;
import com.intelligent.logistics.services.RouteOptimizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteOptimizationService routeOptimizationService;

    @Autowired
    public RouteController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    // Endpoint to generate optimal routes for delivery vehicles
    @PostMapping("/generate")
    public ResponseEntity<List<List<DeliveryOrder>>> generateOptimalRoutes(@RequestBody List<DeliveryOrder> deliveryOrders) {
        List<List<DeliveryOrder>> routes = routeOptimizationService.generateOptimalRoutes(deliveryOrders);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    // Endpoint to assign delivery orders to vehicles and optimize vehicle routes
    @PostMapping("/assign")
    public ResponseEntity<Void> assignAndOptimizeRoutes(@RequestBody List<List<DeliveryOrder>> routes) {
        routeOptimizationService.assignAndOptimizeRoutes(routes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint to continuously monitor route performance and adapt routes in real-time
    @GetMapping("/monitor")
    public ResponseEntity<Void> monitorAndAdaptRoutes(@RequestBody List<List<DeliveryOrder>> routes) {
        routeOptimizationService.monitorAndAdaptRoutes(routes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint to analyze route performance metrics and provide insights
    @GetMapping("/analyze")
    public ResponseEntity<Void> analyzeRoutePerformance(@RequestBody List<List<DeliveryOrder>> routes) {
        routeOptimizationService.analyzeRoutePerformance(routes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint to fetch all routes
    @GetMapping
    public ResponseEntity<List<List<DeliveryOrder>>> getAllRoutes() {
        List<List<DeliveryOrder>> routes = routeOptimizationService.getAllRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    // Endpoint to update a route by ID
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRoute(@PathVariable Long id, @RequestBody List<DeliveryOrder> updatedRoute) {
        routeOptimizationService.updateRoute(id, updatedRoute);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
