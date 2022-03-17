package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Product;
import com.mycommerce.project.utils.JpaDaoManager;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public Product findById(Long aLong) {
        EntityManager em = null;
        Product product = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Product where id = :first");
            query.setParameter("first", aLong);
            product = (Product) query.getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        EntityManager em = null;
        List<Product> productList = new ArrayList<>();
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Product ");
            productList = query.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return productList;
    }

    @Override
    public void add(Product obj) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(obj);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public Product addReturn(Product obj) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Product product = new Product();
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(obj);
            product=em.merge(obj);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }
        return product;
    }


    @Override
    public void update(Product obj) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(obj);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public void remove(Product obj) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            obj = em.merge(obj);
            em.remove(obj);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }

    }

    @Override
    public void removeById(Long aLong) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {

            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            Product product = em.merge(this.findById(aLong));
            em.remove(product);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }
    }
}
