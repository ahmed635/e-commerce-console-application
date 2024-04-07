package entities.impl;

import entities.Product;

public class DefaultProduct implements Product {
    private int id;
    private String productName;
    private String categoryName;
    private double price;

    public DefaultProduct() {
    }

    public DefaultProduct(int id, String productName, String categoryName, double price) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product[id: " + id + " Product Name: " + productName + " Category: " + categoryName + " Price: " + price
                + "]";
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getPrice()
    {
        return price;
    }
}