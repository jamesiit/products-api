package uk.ac.westminster.productsapi.model;

public interface Discountable {

    void applyDiscount(double rate);

    double getDiscountedPrice();

}
