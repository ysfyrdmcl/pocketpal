package com.demo.pocketpal.services.base;



import java.util.List;
import java.util.Optional;

public interface IService <T,ID>{
    T save(T entity);
    Iterable<T>saveAll(Iterable<T>entities);
    T update (T entity);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();

}
