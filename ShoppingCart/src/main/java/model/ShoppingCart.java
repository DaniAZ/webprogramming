package model;

import java.util.ArrayList;
import java.util.HashMap;

public  class ShoppingCart {
   // private HashMap userShoppingCart;
    private static ArrayList<Product> userShoppingCart;
     public ShoppingCart() {
//         userShoppingCart=new HashMap();

    }

    public static   ArrayList<Product> getUserShoppingCart() {
        return userShoppingCart;
    }

    public static void  setUserShoppingCart(Product product) {
        if(userShoppingCart==null)
            userShoppingCart=new ArrayList();
         userShoppingCart.add(product);
    }



    public  String toString() {
         StringBuffer stringBuffer=new StringBuffer();
         for(Product product: userShoppingCart){
             stringBuffer.append(product.getProductName()+product.getProductnumber()+product.getProductPrice()+"\n");
         }
        return stringBuffer.toString();
    }
}

