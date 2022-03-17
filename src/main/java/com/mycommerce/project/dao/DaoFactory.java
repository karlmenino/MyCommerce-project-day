
package com.mycommerce.project.dao;


import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.dao.base.UserDao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static ProductDaoImpl getProductDao() {
        return  new ProductDaoImpl();
    }
    public static UserDaoImpl getUserDao() {
        return  new UserDaoImpl();
    }
    public static CategoryDaoImpl getCategoryDao() {
        return  new CategoryDaoImpl();
    }
}
