package uk.ac.westminster.productsapi.repository;

import org.springframework.stereotype.Repository;
import uk.ac.westminster.productsapi.model.DigitalProduct;
import uk.ac.westminster.productsapi.model.PhysicalProduct;
import uk.ac.westminster.productsapi.model.Product;

import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<Long, Product> store = new HashMap<>();

    private Long nextId = 1L;

    public InMemoryProductRepository() {
        save(new DigitalProduct(null, "Ebook", 19.99, "https://products-api/products/e-book.pdf", 20));
        save(new PhysicalProduct(null, "File", 5.99, 0.07, "22 cm x 31 cm  x 5 cm"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Product save(Product product) {

        if (product.getId() == null)
        {
            product.setId(nextId);
            nextId++;
        }

        store.put(product.getId(), product);

        return product;
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }


}
