package kz.kassen.MIDTERM1.controller;

import kz.kassen.MIDTERM1.dto.ProductDTO;
import kz.kassen.MIDTERM1.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping()
    public List<ProductDTO> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public ProductDTO getById(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    @PostMapping()
    public void createProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
    }
}
