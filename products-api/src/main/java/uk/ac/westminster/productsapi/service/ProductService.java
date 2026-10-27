package uk.ac.westminster.productsapi.service;

import org.springframework.stereotype.Service;
import uk.ac.westminster.productsapi.model.DigitalProduct;
import uk.ac.westminster.productsapi.model.Discountable;
import uk.ac.westminster.productsapi.model.PhysicalProduct;
import uk.ac.westminster.productsapi.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        products.add(new DigitalProduct(nextId++, "Ebook", 19.99, "https://products-api/products/e-book.pdf", 20));
        products.add(new PhysicalProduct(nextId++, "File", 5.99, 0.07, "22 cm x 31 cm  x 5 cm"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    public List<String> getAllSummaries() {

        List<String> summaries = new ArrayList<>();

        for (Product p : products) {
            summaries.add(p.getSummary());
        }

        return summaries;
    }

}
