package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import services.ProductManagementService;
import services.impl.DefaultProductManagementService;
import entities.*;

public class ProductCatalogMenu implements Menu {
    private static final String CHECKOUT_COMMAND = "checkout";
    private ApplicationContext context;
    private ProductManagementService productManagementService;

    {
        context = ApplicationContext.getInstance();
        productManagementService = DefaultProductManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Product[] products = productManagementService.getProducts();
        for(Product product: products) {
            System.out.println(product);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** PRODUCT CATALOG ***");
    }

}
