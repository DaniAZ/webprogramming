package controller;

import model.Product;
import model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value= "/AddToCart")
public class AddToCartServlet extends HttpServlet {
    int productnumber=0;
  // ShoppingCart shoppingCart=new ShoppingCart();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String productPrice=(String)request.getParameter("productPrice");
            String productName=(String)request.getParameter("productName");
            ShoppingCart.setUserShoppingCart(new Product(productnumber,productName,productPrice));
            productnumber++;
           System.out.println(new ShoppingCart().toString());
           request.getSession().setAttribute("products", ShoppingCart.getUserShoppingCart());
           request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
