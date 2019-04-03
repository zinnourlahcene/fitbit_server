package com.fitbitml.service;

import java.io.Serializable;
import java.util.Optional;

public interface IService<T, ID extends Serializable>  {

    public T save(T entity);

    public Iterable<T> saveAll(Iterable<T> entities);

    public Optional<T> findById(ID id);

    public boolean existsById(ID id);

    public Iterable<T> findAll();

    public Iterable<T> findAllById(Iterable<ID> ids);

    public long count();

    public void deleteById(ID id);

    public void delete(T entity);

    public void deleteAll(Iterable<? extends T> entities);

    public void deleteAll();
}
