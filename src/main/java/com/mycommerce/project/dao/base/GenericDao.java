package com.mycommerce.project.dao.base;

import java.util.List;

public interface GenericDao<T, ID extends Number> {

    public T findById(ID id);
    public List<T> findAll();
    public void add(T obj);
    public T addReturn(T obj);

    public void update(T obj);
    public void remove(T obj);
    public void removeById(ID id);
}
