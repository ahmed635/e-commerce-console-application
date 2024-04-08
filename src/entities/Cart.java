package entities;
import java.util.*;

public interface Cart {
    boolean isEmpty();

    void addProduct(Product productById);

    List<Product> getProducts();

    void clear();
}
