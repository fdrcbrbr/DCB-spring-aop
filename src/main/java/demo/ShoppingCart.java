package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkOut(String status){
        System.out.println("Checkout method for shopping cart called");
    }
    public int quantity(){
        return 2;
    }
}

