package uk.ac.westminster.productsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.ac.westminster.productsapi.model.DigitalProduct;
import uk.ac.westminster.productsapi.model.Product;
import uk.ac.westminster.productsapi.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @GetMapping("/products/search")
    public List<Product> findByName(@RequestParam String name) {
        return productService.findByName(name);
    }

    // reference type here should be Product. However since it is abstract, we go with DigitalProduct for now
    @PostMapping("/products")
    public Product addProduct(@RequestBody DigitalProduct product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/summaries")
    public List<String> getAllSummaries() {
        return productService.getAllSummaries();
    }

}
