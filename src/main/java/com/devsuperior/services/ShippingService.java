package com.devsuperior.services;

import org.springframework.stereotype.Service;

import com.devsuperior.entities.Order;

@Service
public class ShippingService {
    public double shipment(Order order) {
        double basic = order.getBasic();

        if (basic < 100) {
            return 20.00;
        } else if (basic < 200) {
            return 12.00;
        } else {
            return 0.0;
        }
    }
}
