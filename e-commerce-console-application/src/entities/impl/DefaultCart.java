package entities.impl;

import entities.Cart;
import entities.Product;

import java.util.Arrays;

public class DefaultCart implements Cart {
    private static final int DEFAULT_PRODUCT_CAPACITY = 10;
    private Product[] products;
    private int orderLength;

    public DefaultCart(){
        this.products = new Product[DEFAULT_PRODUCT_CAPACITY];
        this.orderLength = 0;
    }
    @Override
    public boolean isEmpty() {
        return products.length == 0;
    }

    @Override
    public void addProduct(Product productById) {
        if (productById != null) {
            if (products.length <= orderLength) {
                products = Arrays.copyOf(products, products.length << 1);
            }
            products[orderLength] = productById;
            orderLength++;
        }
    }

    @Override
    public Product[] getProducts() {
        int nonNullProductsAmount = 0;
        for (Product product : products) {
            if (product != null) {
                nonNullProductsAmount++;
            }
        }

        Product[] nonNullProducts = new Product[nonNullProductsAmount];
        int index = 0;
        for (Product product : products) {
            if (product != null) {
                nonNullProducts[index++] = product;
            }
        }

        return nonNullProducts;
    }

    @Override
    public void clear() {
        products = new Product[DEFAULT_PRODUCT_CAPACITY];
    }
}
