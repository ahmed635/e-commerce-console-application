package entities.impl;

import entities.Order;
import entities.Product;

import java.util.Arrays;

public class DefaultOrder implements Order {

    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

    private String creditCardNumber;
    private Product[] products;
    private int customerId;

    @Override
    public boolean isCreditCardNumberValid(String creditCardNumber) {
        return creditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER &&
                !creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber) > 0;
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {
        if(isCreditCardNumberValid(creditCardNumber)){
            this.creditCardNumber = creditCardNumber;
        } else {
            System.out.println("Credit number not void.");
        }
    }

    @Override
    public void setProducts(Product[] products) {
        if(products != null){
            this.products = products;
        } else {
            System.out.println("Chose a void products.");
        }
    }

    @Override
    public void setCustomerId(int customerId) {
        if(customerId != 0){
            this.customerId = customerId;
        } else {
            System.out.println("Wrong curstomer id.");
        }
    }


    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        return "Order: customer id - " + this.customerId + "\t" +
                "credit card number - " + this.creditCardNumber + "\t" +
                "products - " + Arrays.toString(this.products);
    }
}
