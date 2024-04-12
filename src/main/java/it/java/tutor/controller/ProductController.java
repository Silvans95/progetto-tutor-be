package it.java.tutor.controller;

import it.java.tutor.dto.ProductAutocompleteDto;
import it.java.tutor.dto.ProductDto;
import it.java.tutor.exception.TutorException;
import it.java.tutor.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "api/product", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/{productName}")
    public ResponseEntity<List<ProductAutocompleteDto>> getProductsByNameLike(@PathVariable String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.getProductsByNameLike(productName));
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertProduct(@RequestBody ProductDto productDto) {

        try {

            ProductDto response = productService.insertProduct(productDto);
            log.info("Product created with id: " + response.getId());
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (TutorException e) {
            log.error(e.getStackTrace());
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }

    }

}
