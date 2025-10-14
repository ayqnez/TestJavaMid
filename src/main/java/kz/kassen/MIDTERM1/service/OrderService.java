package kz.kassen.MIDTERM1.service;

import kz.kassen.MIDTERM1.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> findAll();
    List<OrderDTO> findOrdersByUserId(Long userId);
    void createOrderForUser(Long userId);
    void addProductToUserOrder(Long productId, Long orderId);
    void removeProductFromUserOrder(Long productId, Long orderId);
    void deleteOrderById(Long orderId);
}
