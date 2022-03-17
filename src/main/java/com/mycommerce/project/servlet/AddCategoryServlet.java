package com.mycommerce.project.servlet;


import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/add-category")
public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addCategory.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("pName");
        String categoryDescription = req.getParameter("pDescr");

        try {
            Category newCateg = new Category(categoryName,categoryDescription);
            CategoryDao categoryDao = DaoFactory.getCategoryDao();
            newCateg=categoryDao.addReturn(newCateg);
            resp.sendRedirect(ShowCategoryServlet.URL + "?id=" + newCateg.getId());

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
