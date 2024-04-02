package it.java.tutor.dto;

import it.java.tutor.model.Product;
import it.java.tutor.model.StatusEnum;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto implements Serializable {

    private Long id;

    @NonNull
    private String productName;

    private String productDescription;

    @NonNull
    private StatusEnum status;

    @Min(value = 0)
    @NonNull
    private Double price;

    public static Product fromDTOtoModel(ProductDto dto) {
        return Product.builder()
                .id(dto.id)
                .productName(dto.productName)
                .productDescription(dto.productDescription)
                .status(dto.status)
                .price(dto.price)
                .build();
    }

    public static ProductDto fromModelToDTO(Product model) {
        return ProductDto.builder()
                .id(model.getId())
                .productName(model.getProductName())
                .productDescription(model.getProductDescription())
                .status(model.getStatus())
                .price(model.getPrice())
                .build();
    }

    public static List<ProductDto> fromModelListToDTOList(List<Product> list) {
        List<ProductDto> dtoList = new ArrayList<>();
        list.forEach(ele -> dtoList.add(fromModelToDTO(ele)));
        return dtoList;
    }
}

