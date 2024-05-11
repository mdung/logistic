package com.intelligent.logistics.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String deliveryAddress;
    private LocalDateTime deliveryTime;
    private int volume; // Volume of the delivery order

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_delivery_order_id")
    private List<DeliveryOrder> deliveryOrders;

    // Constructors
    public DeliveryOrder() {
    }

    public DeliveryOrder(String customerName, String deliveryAddress, LocalDateTime deliveryTime, int volume) {
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
        this.deliveryTime = deliveryTime;
        this.volume = volume;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    // Getters and setters for other properties...

    // toString() method
    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", volume=" + volume +
                '}';
    }

    public void setDeliveryOrders(List<DeliveryOrder> deliveryOrders) {
        this.deliveryOrders = deliveryOrders;
    }

    public List<DeliveryOrder> getDeliveryOrders() {
        return deliveryOrders;
    }
}
