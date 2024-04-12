package it.java.tutor.service;

import it.java.tutor.dto.ProductAutocompleteDto;
import it.java.tutor.dto.ProductDto;
import it.java.tutor.exception.TutorException;
import it.java.tutor.repository.ProductRepository;
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

    public List<ProductAutocompleteDto> getProductsByNameLike(String productName) {
        return this.productRepository.findByNameLike(productName);
    }

    public ProductDto insertProduct(ProductDto dto) throws TutorException {

        if (dto.getProductName() == null || dto.getProductName().isEmpty() || dto.getProductName().isBlank()) {
            throw TutorException.badRequest("Product name must be valued");
        }
        if (dto.getPrice() <= 0) {
            throw TutorException.badRequest("Product price must be greater than zero");
        }

        return ProductDto.fromModelToDTO(productRepository.save(ProductDto.fromDTOtoModel(dto)));
    }


}

