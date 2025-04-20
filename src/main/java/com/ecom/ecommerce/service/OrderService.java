package com.ecom.ecommerce.service;

import com.ecom.ecommerce.payload.OrderDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    @Transactional
    OrderDTO placeOrder(String emailId, String addressId, String paymentMethod, String pgName, String pgPaymentId, String pgStatus, String pgResponseMessage);
}
