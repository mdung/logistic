package com.intelligent.logistics.controllers;

import com.intelligent.logistics.models.DeliveryOrder;
import com.intelligent.logistics.services.DeliveryOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery-orders")
@CrossOrigin(origins = "http://localhost:3000")
public class DeliveryOrderController {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryOrderController.class);

    private final DeliveryOrderService deliveryOrderService;

    @Autowired
    public DeliveryOrderController(DeliveryOrderService deliveryOrderService) {
        this.deliveryOrderService = deliveryOrderService;
    }

    @GetMapping
    public ResponseEntity<List<DeliveryOrder>> getAllDeliveryOrders() {
        logger.info("Fetching all delivery orders");
        List<DeliveryOrder> deliveryOrders = deliveryOrderService.getAllDeliveryOrders();
        return new ResponseEntity<>(deliveryOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryOrder> getDeliveryOrderById(@PathVariable Long id) {
        logger.info("Fetching delivery order with ID: {}", id);
        Optional<DeliveryOrder> deliveryOrder = deliveryOrderService.getDeliveryOrderById(id);
        return deliveryOrder.map(value -> {
            logger.info("Delivery order found: {}", value);
            return new ResponseEntity<>(value, HttpStatus.OK);
        }).orElseGet(() -> {
            logger.warn("Delivery order not found with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        });
    }

    @PostMapping
    public ResponseEntity<DeliveryOrder> createDeliveryOrder(@RequestBody DeliveryOrder deliveryOrder) {
        logger.info("Creating new delivery order: {}", deliveryOrder);
        DeliveryOrder createdDeliveryOrder = deliveryOrderService.createDeliveryOrder(deliveryOrder);
        logger.info("Created delivery order: {}", createdDeliveryOrder);
        return new ResponseEntity<>(createdDeliveryOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryOrder> updateDeliveryOrder(@PathVariable Long id, @RequestBody DeliveryOrder updatedDeliveryOrder) {
        logger.info("Updating delivery order with ID: {}", id);
        DeliveryOrder updatedOrder = deliveryOrderService.updateDeliveryOrder(id, updatedDeliveryOrder);
        if (updatedOrder != null) {
            logger.info("Updated delivery order: {}", updatedOrder);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            logger.warn("Delivery order not found with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryOrder(@PathVariable Long id) {
        logger.info("Deleting delivery order with ID: {}", id);
        deliveryOrderService.deleteDeliveryOrder(id);
        logger.info("Deleted delivery order with ID: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
