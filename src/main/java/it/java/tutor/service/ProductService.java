package it.java.tutor.service;

import it.java.tutor.dto.ProductDto;
import it.java.tutor.repository.ProductRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.hibernate.PropertyValueException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<ProductDto> getAllProducts() {
        return ProductDto.fromModelListToDTOList(productRepository.findAll());
    }

    public ProductDto insertProduct(ProductDto dto) {
        return ProductDto.fromModelToDTO(productRepository.save(ProductDto.fromDTOtoModel(dto)));
    }

}

