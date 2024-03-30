package entities.impl;

import entities.Cart;
import entities.Product;

public class DefaultCart implements Cart {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void addProduct(Product productById) {

    }

    @Override
    public Product[] getProducts() {
        return new Product[0];
    }

    @Override
    public void clear() {

    }
}
