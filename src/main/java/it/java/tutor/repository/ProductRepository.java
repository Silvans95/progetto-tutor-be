package it.java.tutor.repository;

import it.java.tutor.dto.ProductAutocompleteDto;
import it.java.tutor.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select new it.java.tutor.dto.ProductAutocompleteDto(p.id, p.productName) from Product p where p.productName like :productName% ")
    List<ProductAutocompleteDto> findByNameLike(String productName);

}
