package uk.ac.westminster.productsapi.model;

// A PhysicalProduct is a product because it needs id name and price. A class like say, a ShoppingCart has a Product because it contains Product hence its a "has a" relationship

public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    public PhysicalProduct() {
    }
}
