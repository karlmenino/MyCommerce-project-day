package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.model.Category;
import com.mycommerce.project.model.Product;
import com.mycommerce.project.utils.JpaDaoManager;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public Category findById(Long aLong) {
        EntityManager em = null;
        Category category = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Category where id = :first");
            query.setParameter("first", aLong);
            category = (Category) query.getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        EntityManager em = null;
        List<Category> categoryList = new ArrayList<>();
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Category ");
            categoryList = query.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return categoryList;
    }

    @Override
    public void add(Category obj) {
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
    public Category addReturn(Category obj) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Category category = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(obj);
            category=em.merge(obj);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }
        return category;

    }

    @Override
    public void update(Category obj) {
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
    public void remove(Category obj) {
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
            Category category = em.merge(this.findById(aLong));
            em.remove(category);
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

