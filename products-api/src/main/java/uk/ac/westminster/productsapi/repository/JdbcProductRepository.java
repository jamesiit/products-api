package uk.ac.westminster.productsapi.repository;

import org.springframework.stereotype.Repository;
import uk.ac.westminster.productsapi.model.DigitalProduct;
import uk.ac.westminster.productsapi.model.PhysicalProduct;
import uk.ac.westminster.productsapi.model.Product;

import java.util.*;

@Repository
public class JdbcProductRepository implements ProductRepository  {

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
