package lkijse.OnlineBookstoreApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import lkijse.OnlineBookstoreApplication.repository.ShoppingCartRepository;

@CrossOrigin(origins = "*")
public class ShoppingCartController {
     @Autowired
    private ShoppingCartRepository cartRepository;

   
}
