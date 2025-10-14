package kz.kassen.MIDTERM1.mapper;

import kz.kassen.MIDTERM1.dto.OrderDTO;
import kz.kassen.MIDTERM1.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ProductMapper.class})
public interface OrderMapper {

    @Mapping(target = "userDTO", source = "user")
    @Mapping(target = "productsDTO", source = "products")
    OrderDTO toDto(Order order);

    @Mapping(target = "user", source = "userDTO")
    @Mapping(target = "products", source = "productsDTO")
    Order toEntity(OrderDTO orderDTO);

    List<OrderDTO> toDtoList(List<Order> orders);
}
