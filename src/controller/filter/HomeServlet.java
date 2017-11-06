package controller.filter;

import data.entity.User;
import helper.AppConstants;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class HomeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //check session
        User loggedInUser = (User) request.getSession().getAttribute(AppConstants.getLoggedInUserSessionKey());
        if(loggedInUser == null){
            //take it to login
            request.setAttribute("Message","Session Logged Out");
            response.sendRedirect("/login.jsp");
        }
        else{
            //redirect to dashboard
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("Message","Session Logged Out");
            requestDispatcher.forward(request, response);
        }
    }
}
