package uk.ac.westminster.productsapi.service;

import org.springframework.stereotype.Service;
import uk.ac.westminster.productsapi.exception.ProductNotFoundException;
import uk.ac.westminster.productsapi.model.Product;
import uk.ac.westminster.productsapi.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository prodRepo;

    public ProductService(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    public List<Product> getAllProducts() {
        return prodRepo.findAll();
    }

    public Product addProduct(Product product) {
        return prodRepo.save(product);
    }

    public Product getProductById(Long id) {
        return prodRepo.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id));

    }

    public void deleteProduct(Long id) {
        getProductById(id);
        prodRepo.delete(id);
    }

    public List<Product> findByName(String name) {
        return prodRepo.findAll().stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    public List<String> getAllSummaries() {

        List<String> summaries = new ArrayList<>();

        for (Product p : prodRepo.findAll()) {
            summaries.add(p.getSummary());
        }

        return summaries;
    }

}
