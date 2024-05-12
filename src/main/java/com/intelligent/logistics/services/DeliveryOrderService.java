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
        Optional<DeliveryOrder> optionalDeliveryOrder = deliveryOrderRepository.findById(id);
        if (optionalDeliveryOrder.isPresent()) {
            DeliveryOrder existingDeliveryOrder = optionalDeliveryOrder.get();
            // Update the existing delivery order with the provided data
            existingDeliveryOrder.setCustomerName(updatedDeliveryOrder.getCustomerName());
            existingDeliveryOrder.setDeliveryAddress(updatedDeliveryOrder.getDeliveryAddress());
            existingDeliveryOrder.setDeliveryTime(updatedDeliveryOrder.getDeliveryTime());
            existingDeliveryOrder.setVolume(updatedDeliveryOrder.getVolume());
            // Update other properties as needed
            return deliveryOrderRepository.save(existingDeliveryOrder);
        } else {
            // Handle case where delivery order with given id is not found
            // You can throw an exception or handle it as per your requirement
            return null;
        }
    }

    public void deleteDeliveryOrder(Long id) {
        deliveryOrderRepository.deleteById(id);
    }
}
