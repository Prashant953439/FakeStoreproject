package dev.prashant.productservicemorning.repositories;

import dev.prashant.productservicemorning.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product p);

    @Override
    List<Product> findAll();

    Product findByIdIs(Long id);
}
