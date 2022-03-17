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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(AddPanier.url)
public class AddPanier extends HttpServlet {

    public static final String url ="/auth/add-panier";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addPanier.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("productId");
        HttpSession session = req.getSession();
        if (idStr == null) {
            List<Product> products = new ArrayList<>();
            session.setAttribute("panierList", products);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addPanier.jsp");
            rd.forward(req, resp);
            return;
        }
        try {
            Long id = Long.parseLong(idStr);
            ProductDao dao = DaoFactory.getProductDao();
            Product product = dao.findById(id);

            List<Product> productList = new ArrayList<>();
            if (session.getAttribute("panierList") != null) {
                 productList = (List<Product>) session.getAttribute("panierList");
            }
            productList.add(product);
            session.setAttribute("panierList", productList);
            resp.sendRedirect(AddPanier.url);

        } catch (NumberFormatException e) {
            System.out.println("ça à foirer");
        }
    }


}
