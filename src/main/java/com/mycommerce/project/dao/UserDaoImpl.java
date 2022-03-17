package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.UserDao;
import com.mycommerce.project.model.User;
import com.mycommerce.project.model.Product;
import com.mycommerce.project.model.User;
import com.mycommerce.project.utils.JpaDaoManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User findById(Long aLong) {
        EntityManager em = null;
        User user = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from User where id = :first");
            query.setParameter("first", aLong);
            user = (User) query.getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return user;
    }

    public User findByLogin(String login)  {
        EntityManager em = null;
        User user = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from User where login = :first");
            query.setParameter("first", login);
            user = (User) query.getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        EntityManager em = null;
        List<User> userArrayList = new ArrayList<>();
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from User ");
            userArrayList = query.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return userArrayList;
    }

    @Override
    public void add(User obj) {
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
    public User addReturn(User obj) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(obj);
            user=em.merge(obj);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }
        return user;
    }

    @Override
    public void update(User obj) {
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
    public void remove(User obj) {
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
            User user = em.merge(this.findById(aLong));
            em.remove(user);
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
