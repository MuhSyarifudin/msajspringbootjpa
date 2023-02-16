package com.juaracoding.msajspringbootjpa.controller;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 16/02/2023 21:45
@Last Modified 16/02/2023 21:45
Version 1.1
*/

import com.juaracoding.msajspringbootjpa.model.Product;
import com.juaracoding.msajspringbootjpa.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

    @RestController
    @RequestMapping("api/ops/")
    public class ProductController {

        private ProductService productService;

        private String[] strExcep = new String[2];

        @Autowired
        private ModelMapper modelMapper;

        @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }

        @PostMapping("v1/sv")
        public ResponseEntity<Object> saveProduct(@Valid
                                                  @RequestBody Product product
        )
        {
            return productService.saveProduct(product);

        }



    }
