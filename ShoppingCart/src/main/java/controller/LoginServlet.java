package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.UserUtil.getUsers;


//import static wap.w3d3.util.UserUtil.getUsers;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    String userCookie;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (User user: getUsers()){
            if(user.getUserName().equals(request.getParameter("username")) &&
                    user.getPassword().equals(request.getParameter("password"))){
                request.getSession().setAttribute("name",request.getParameter("username"));
                userCookie=(String) request.getSession().getAttribute("name");
                        //adding a cookie
               if("on".equals(request.getParameter("remember")))
                {
                       Cookie userNameCookie = new Cookie("user", (String) request.getSession().getAttribute("name"));
                       //setting a cookie for month
                       userNameCookie.setMaxAge(2629746);
                       userNameCookie.setPath("/");
                       response.addCookie(userNameCookie);
                   }
                   else
                   {
                       Cookie userNameCookie = new Cookie("user", null);
                       //setting a cookie for month
                       userNameCookie.setMaxAge(0);
                       userNameCookie.setPath("/");
                       response.addCookie(userNameCookie);
                   }
                  //creating a cookie named promo
                   Cookie promo=new Cookie("promo","$100");
                   promo.setMaxAge(30*24*60*60);
                   response.addCookie(promo);
                //   request.getRequestDispatcher("WEB-INF/jsp/checkout.jsp").forward(request,response);
                   request.getRequestDispatcher("index.jsp").forward(request,response);
              //  response.sendRedirect("WEB-INF/jsp/welcome.jsp");
                return;
            }
        }
        request.getSession().setAttribute("Message","please enter user name or password");
       response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getCookies()!=null) {
                 for (Cookie cookie : request.getCookies()) {
                         if (cookie.getValue().equals(userCookie)) {
                          request.getSession().setAttribute("userName",userCookie);
                     }
                 }
             }
             request.getRequestDispatcher("index.jsp").forward(request,response);
        //response.sendRedirect("index.jsp");
    }
}
