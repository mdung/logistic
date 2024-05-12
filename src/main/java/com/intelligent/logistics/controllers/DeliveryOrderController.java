package com.intelligent.logistics.controllers;

import com.intelligent.logistics.models.DeliveryOrder;
import com.intelligent.logistics.services.DeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery-orders")
public class DeliveryOrderController {

    private final DeliveryOrderService deliveryOrderService;

    @Autowired
    public DeliveryOrderController(DeliveryOrderService deliveryOrderService) {
        this.deliveryOrderService = deliveryOrderService;
    }

    @GetMapping
    public ResponseEntity<List<DeliveryOrder>> getAllDeliveryOrders() {
        List<DeliveryOrder> deliveryOrders = deliveryOrderService.getAllDeliveryOrders();
        return new ResponseEntity<>(deliveryOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryOrder> getDeliveryOrderById(@PathVariable Long id) {
        Optional<DeliveryOrder> deliveryOrder = deliveryOrderService.getDeliveryOrderById(id);
        return deliveryOrder.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DeliveryOrder> createDeliveryOrder(@RequestBody DeliveryOrder deliveryOrder) {
        DeliveryOrder createdDeliveryOrder = deliveryOrderService.createDeliveryOrder(deliveryOrder);
        return new ResponseEntity<>(createdDeliveryOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryOrder> updateDeliveryOrder(@PathVariable Long id, @RequestBody DeliveryOrder updatedDeliveryOrder) {
        DeliveryOrder updatedOrder = deliveryOrderService.updateDeliveryOrder(id, updatedDeliveryOrder);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryOrder(@PathVariable Long id) {
        deliveryOrderService.deleteDeliveryOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
