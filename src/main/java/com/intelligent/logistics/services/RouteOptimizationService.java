package com.intelligent.logistics.services;

import com.intelligent.logistics.models.DeliveryOrder;
import com.intelligent.logistics.models.Vehicle;
import com.intelligent.logistics.repositories.RouteRepository;
import com.intelligent.logistics.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteOptimizationService {

    private static final Logger logger = LoggerFactory.getLogger(RouteOptimizationService.class);
    private final VehicleRepository vehicleRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public RouteOptimizationService(VehicleRepository vehicleRepository, RouteRepository routeRepository) {
        this.vehicleRepository = vehicleRepository;
        this.routeRepository = routeRepository;
    }

    // Method to generate optimal routes for delivery vehicles
    public List<List<DeliveryOrder>> generateOptimalRoutes(List<DeliveryOrder> deliveryOrders) {
        // Placeholder: Simple algorithm to split orders evenly among vehicles
        List<List<DeliveryOrder>> routes = new ArrayList<>();
        List<Vehicle> vehicles = vehicleRepository.findAll(); // Retrieve all vehicles from the database
        int ordersPerVehicle = deliveryOrders.size() / vehicles.size();
        for (int i = 0; i < vehicles.size(); i++) {
            List<DeliveryOrder> route = new ArrayList<>();
            for (int j = 0; j < ordersPerVehicle; j++) {
                route.add(deliveryOrders.remove(0));
            }
            routes.add(route);
        }
        return routes;
    }

    public void assignAndOptimizeRoutes(List<List<DeliveryOrder>> routes) {
        // Retrieve all vehicles from the database
        List<Vehicle> vehicles = vehicleRepository.findAll();

        // Ensure that there are routes and vehicles available
        if (routes.isEmpty() || vehicles.isEmpty()) {
            // Log a message if there are no routes or vehicles available
            logger.warn("No routes or vehicles available for assignment.");
            return;
        }

        // Assign routes to vehicles
        int numRoutes = routes.size();
        int numVehicles = vehicles.size();
        for (int i = 0; i < Math.min(numRoutes, numVehicles); i++) {
            Vehicle vehicle = vehicles.get(i);
            List<DeliveryOrder> route = routes.get(i);

            vehicleRepository.save(vehicle); // Save the updated vehicle to the database

            // Log the assignment of route to vehicle
            logger.info("Assigned route {} to vehicle {}.", i + 1, vehicle.getId());
        }
    }

    // Method to continuously monitor route performance and adapt routes in real-time
    public void monitorAndAdaptRoutes(List<List<DeliveryOrder>> routes) {
        // Placeholder: No real-time monitoring, simply print routes
        for (List<DeliveryOrder> route : routes) {
            System.out.println("Route: " + route);
        }
    }

    // Method to analyze route performance metrics and provide insights
    public void analyzeRoutePerformance(List<List<DeliveryOrder>> routes) {
        // Placeholder: No analytics, simply print route metrics
        for (int i = 0; i < routes.size(); i++) {
            List<DeliveryOrder> route = routes.get(i);
            int totalOrders = route.size();
            System.out.println("Route " + (i + 1) + " has " + totalOrders + " delivery orders.");
        }
    }

    // Method to retrieve all routes
    public List<List<DeliveryOrder>> getAllRoutes() {
        // Fetch all routes from the database using Spring Data JPA repository
        List<List<DeliveryOrder>> allRoutes = routeRepository.findAllRoutes();

        // Optionally, perform any additional processing or filtering of routes here

        return allRoutes;
    }

    public void updateRoute(Long id, List<DeliveryOrder> updatedRoute) {
        // Retrieve the route from the database
        Optional<DeliveryOrder> optionalRoute = routeRepository.findById(id);
        if (optionalRoute.isPresent()) {
            DeliveryOrder existingRoute = optionalRoute.get();
            // Update the route
           // existingRoute.setDeliveryOrders(updatedRoute);
            routeRepository.save(existingRoute);
            logger.info("Route {} updated successfully.", id);
        } else {
            logger.warn("Route with id {} not found.", id);
        }
    }

}
