package entities.impl;

import entities.Cart;
import entities.Product;
import java.util.*;

public class DefaultCart implements Cart {
    private List<Product> products;

    {
        this.products = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return products.size() == 0;
    }

    @Override
    public void addProduct(Product productById) {
        if (productById != null) {
            products.add(productById);
        }
    }

    @Override
    public List<Product> getProducts() {
        return this.products;
    }

    @Override
    public void clear() {
        products = new ArrayList<>();
    }
}
