package lkijse.OnlineBookstoreApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import lkijse.OnlineBookstoreApplication.repository.SubcategoryRepository;

@CrossOrigin(origins = "*")
public class SubcategoryController {
     @Autowired
    private SubcategoryRepository subcategoryRepository;

   
}
