package kz.kassen.MIDTERM1.service;

import kz.kassen.MIDTERM1.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(Long productId);
    void createProduct(ProductDTO productDTO);
}
