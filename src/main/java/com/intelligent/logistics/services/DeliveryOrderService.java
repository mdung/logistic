package com.intelligent.logistics.services;

import com.intelligent.logistics.models.DeliveryOrder;
import com.intelligent.logistics.repositories.DeliveryOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryOrderService {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryOrderService.class);

    private final DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    public DeliveryOrderService(DeliveryOrderRepository deliveryOrderRepository) {
        this.deliveryOrderRepository = deliveryOrderRepository;
    }

    public List<DeliveryOrder> getAllDeliveryOrders() {
        return deliveryOrderRepository.findAll();
    }

    public Optional<DeliveryOrder> getDeliveryOrderById(Long id) {
        return deliveryOrderRepository.findById(id);
    }

    public DeliveryOrder createDeliveryOrder(DeliveryOrder deliveryOrder) {
        return deliveryOrderRepository.save(deliveryOrder);
    }

    public DeliveryOrder updateDeliveryOrder(Long id, DeliveryOrder updatedDeliveryOrder) {
        logger.info("Updating delivery order with ID: {}", id);
        return deliveryOrderRepository.findById(id)
                .map(existingDeliveryOrder -> {
                    // Update the existing delivery order with the provided data
                    existingDeliveryOrder.setCustomerName(updatedDeliveryOrder.getCustomerName());
                    existingDeliveryOrder.setDeliveryAddress(updatedDeliveryOrder.getDeliveryAddress());
                    existingDeliveryOrder.setDeliveryTime(updatedDeliveryOrder.getDeliveryTime());
                    existingDeliveryOrder.setVolume(updatedDeliveryOrder.getVolume());
                    existingDeliveryOrder.setVehicle(updatedDeliveryOrder.getVehicle()); // Set the associated vehicle

                    // Log the updated delivery order details
                    logger.info("Updated delivery order details: {}", existingDeliveryOrder);

                    return deliveryOrderRepository.save(existingDeliveryOrder);
                })
                .orElseGet(() -> {
                    logger.warn("Delivery order not found with ID: {}", id);
                    return null;
                });
    }

    public void deleteDeliveryOrder(Long id) {
        logger.info("Deleting delivery order with ID: {}", id);
        deliveryOrderRepository.deleteById(id);
        logger.info("Deleted delivery order with ID: {}", id);
    }
}
