package lkijse.OnlineBookstoreApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import lkijse.OnlineBookstoreApplication.repository.CategoryRepository;

@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

  
}
