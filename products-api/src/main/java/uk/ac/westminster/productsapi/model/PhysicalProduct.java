package uk.ac.westminster.productsapi.model;

// A PhysicalProduct is a product because it needs id name and price. A class like say, a ShoppingCart has a Product because it contains Product hence it's a "has a" relationship

public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

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

    @Override
    public String getSummary() {
        return getName() + " - £" + getPrice() + " weight: " + getWeightKg();
    }

    public PhysicalProduct() {
    }

    // We are implementing different method bodies from the same interface method
    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

}
