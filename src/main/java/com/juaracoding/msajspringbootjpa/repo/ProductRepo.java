package com.juaracoding.msajspringbootjpa.repo;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 16/02/2023 21:19
@Last Modified 16/02/2023 21:19
Version 1.1
*/

import com.juaracoding.msajspringbootjpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
