package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.UserDaoImpl;
import com.mycommerce.project.dao.base.UserDao;
import com.mycommerce.project.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(LoginServlet.URL)
public class LoginServlet extends HttpServlet {

    public final static String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            UserDaoImpl dao = DaoFactory.getUserDao();
            User user = dao.findByLogin(username);
            if (user.getPassword().equalsIgnoreCase(password)) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user", user);
                resp.sendRedirect(ListProductServlet.URL);
            } else {
                resp.sendRedirect(LoginServlet.URL);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.sendRedirect(LoginServlet.URL);
        }
    }
}
