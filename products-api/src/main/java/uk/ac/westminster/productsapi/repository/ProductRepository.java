package uk.ac.westminster.productsapi.repository;

import uk.ac.westminster.productsapi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

     List<Product> findAll();

     Optional<Product> findById(long id);

     Product save(Product product);

     void delete(Long id);

}
