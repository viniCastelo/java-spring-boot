package com.udemy.javaspringboot.services;

import com.udemy.javaspringboot.entities.Category;
import com.udemy.javaspringboot.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

    public List<Category> findAll(){
        List<Category> list = repository.findAll();
        return list;
    }

}