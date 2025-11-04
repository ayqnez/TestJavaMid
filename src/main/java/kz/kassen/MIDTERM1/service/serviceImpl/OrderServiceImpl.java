package kz.kassen.MIDTERM1.service.serviceImpl;

import jakarta.transaction.Transactional;
import kz.kassen.MIDTERM1.dto.OrderDTO;
import kz.kassen.MIDTERM1.entity.Order;
import kz.kassen.MIDTERM1.entity.Product;
import kz.kassen.MIDTERM1.entity.User;
import kz.kassen.MIDTERM1.mapper.OrderMapper;
import kz.kassen.MIDTERM1.repo.OrderRepo;
import kz.kassen.MIDTERM1.repo.ProductRepo;
import kz.kassen.MIDTERM1.repo.UserRepo;
import kz.kassen.MIDTERM1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;

    @Override
    public List<OrderDTO> findAll() {
        return orderMapper.toDtoList(orderRepo.findAll());
    }

    @Override
    public List<OrderDTO> findOrdersByUserId(Long userId) {
        return orderMapper.toDtoList(orderRepo.findOrdersByUserId(userId));
    }

    @Override
    public void createOrderForUser(Long userId) {
        User user = userRepo.findById(userId).orElse(null);

        Order order = new Order();
        order.setUser(user);

        orderRepo.save(order);
    }

    @Override
    public void addProductToUserOrder(Long productId, Long orderId) {
        Product product = productRepo.findById(productId).orElseThrow();
        Order order = orderRepo.findById(orderId).orElseThrow();

        order.getProducts().add(product);

        orderRepo.save(order);
    }

    @Override
    public void removeProductFromUserOrder(Long productId, Long orderId) {
        Product product = productRepo.findById(productId).orElse(null);
        Order order = orderRepo.findById(orderId).orElseThrow();

        order.getProducts().remove(product);

        orderRepo.save(order);
    }

    @Override
    @Transactional
    public void deleteOrderById(Long orderId) {
        orderRepo.deleteOrderById(orderId);
    }
}
