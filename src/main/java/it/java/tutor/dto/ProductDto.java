package it.java.tutor.dto;

import it.java.tutor.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String productName;
    private String productDescription;
    private double price;

    public static Product fromDTOtoModel(ProductDto dto) {
        return Product.builder()
                .id(dto.id)
                .productName(dto.productName)
                .productDescription(dto.productDescription)
                .price(dto.price)
                .build();
    }

    public static ProductDto fromModelToDTO(Product model) {
        return ProductDto.builder()
                .id(model.getId())
                .productName(model.getProductName())
                .productDescription(model.getProductDescription())
                .price(model.getPrice())
                .build();
    }

    public static List<ProductDto> fromModelListToDTOList(List<Product> list) {
        List<ProductDto> dtoList = new ArrayList<>();
        list.forEach(ele -> dtoList.add(fromModelToDTO(ele)));
        return dtoList;
    }
}

