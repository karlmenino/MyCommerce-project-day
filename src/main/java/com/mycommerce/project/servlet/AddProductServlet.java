package com.mycommerce.project.servlet;


import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/auth/add-product")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDao dao= DaoFactory.getCategoryDao();
        List<Category> categoryList = dao.findAll();
        req.setAttribute("liste", categoryList);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("pName");
        String productContent = req.getParameter("pContent");
        String productPriceStr = req.getParameter("pPrice");
        String productCategStr = req.getParameter("categ");


        try {
            float productPrice = Float.parseFloat(productPriceStr);
            Long categId = Long.parseLong(productCategStr);
            Product newProduct = new Product(productName, productContent, productPrice);
            CategoryDao categoryDao = DaoFactory.getCategoryDao();
            newProduct.setCategory(categoryDao.findById(categId));
            ProductDao productDao = DaoFactory.getProductDao();
            newProduct=productDao.addReturn(newProduct);
            resp.sendRedirect(ShowProductServlet.URL + "?id=" + newProduct.getId());

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
