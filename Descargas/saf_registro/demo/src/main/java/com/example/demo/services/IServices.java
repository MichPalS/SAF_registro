package com.example.demo.services;

import java.util.List;
import java.util.Optional;

public interface IServices <T>{
    List<T> getAll();
    Optional<T> getById(Long id);
    T save(T item);
    Optional<T> deleteById(Long id);
}
