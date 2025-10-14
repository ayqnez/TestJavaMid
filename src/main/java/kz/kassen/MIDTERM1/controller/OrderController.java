package kz.kassen.MIDTERM1.controller;

import kz.kassen.MIDTERM1.dto.OrderDTO;
import kz.kassen.MIDTERM1.service.serviceImpl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;

    @GetMapping()
    public List<OrderDTO> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/{userId}")
    public List<OrderDTO> getByUserId(@PathVariable Long userId) {
        return orderService.findOrdersByUserId(userId);
    }

    @PostMapping("/{userId}")
    public void createOrder(@PathVariable Long userId) {
        orderService.createOrderForUser(userId);
    }

    @PostMapping("/{orderId}/add/{productId}")
    public void addProductToOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.addProductToUserOrder(productId, orderId);
    }

    @PostMapping("/{orderId}/remove/{productId}")
    public void removeProductFromOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.removeProductFromUserOrder(productId, orderId);
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
    }
}
