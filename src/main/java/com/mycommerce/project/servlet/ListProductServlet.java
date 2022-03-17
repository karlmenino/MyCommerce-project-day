package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(ListProductServlet.URL)
public class ListProductServlet extends HttpServlet {

    public final static String URL = "/list-product";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetching all products
        ProductDao productDao = DaoFactory.getProductDao();
        List<Product> productList = productDao.findAll();

        // Passing data in view
        req.setAttribute("productList", productList);

        // Forwarding/Displaying listProduct JSP
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listProduct.jsp");
        rd.forward(req, resp);

    }
}
