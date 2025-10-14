package kz.kassen.MIDTERM1.service.serviceImpl;

import kz.kassen.MIDTERM1.dto.ProductDTO;
import kz.kassen.MIDTERM1.mapper.ProductMapper;
import kz.kassen.MIDTERM1.repo.ProductRepo;
import kz.kassen.MIDTERM1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> findAll() {
        return productMapper.toDtoList(productRepo.findAll());
    }

    @Override
    public ProductDTO findById(Long productId) {
        return productMapper.toDto(productRepo.findById(productId).orElse(null));
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepo.save(productMapper.toEntity(productDTO));
    }
}
