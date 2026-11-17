package uk.ac.westminster.productsapi.exception;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(Long id) {
    super("Product not found with id:" + id);
  }
}
