package kz.kassen.MIDTERM1.mapper;

import kz.kassen.MIDTERM1.dto.ProductDTO;
import kz.kassen.MIDTERM1.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "name", target = "nameDTO")
    @Mapping(source = "description", target = "descriptionDTO")
    @Mapping(source = "price", target = "priceDTO")
    @Mapping(source = "inStock", target = "inStockDTO")
    ProductDTO toDto(Product product);

    @Mapping(source = "nameDTO", target = "name")
    @Mapping(source = "descriptionDTO", target = "description")
    @Mapping(source = "priceDTO", target = "price")
    @Mapping(source = "inStockDTO", target = "inStock")
    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> toDtoList(List<Product> products);
}
