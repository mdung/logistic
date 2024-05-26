package com.intelligent.logistics.services;

import com.intelligent.logistics.models.DeliveryOrder;
import com.intelligent.logistics.repositories.DeliveryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryOrderService {

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
        return deliveryOrderRepository.findById(id).map(existingOrder -> {
            existingOrder.setCustomerName(updatedDeliveryOrder.getCustomerName());
            existingOrder.setDeliveryAddress(updatedDeliveryOrder.getDeliveryAddress());
            existingOrder.setDeliveryTime(updatedDeliveryOrder.getDeliveryTime());
            existingOrder.setVolume(updatedDeliveryOrder.getVolume());
            existingOrder.setVehicle(updatedDeliveryOrder.getVehicle());
            existingOrder.setDriver(updatedDeliveryOrder.getDriver());
            return deliveryOrderRepository.save(existingOrder);
        }).orElse(null);
    }

    public void deleteDeliveryOrder(Long id) {
        deliveryOrderRepository.deleteById(id);
    }
}
