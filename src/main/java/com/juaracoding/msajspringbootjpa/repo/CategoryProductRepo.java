package com.juaracoding.msajspringbootjpa.repo;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 13/02/2023 22:53
@Last Modified 13/02/2023 22:53
Version 1.1
*/

import com.juaracoding.msajspringbootjpa.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryProductRepo extends JpaRepository<CategoryProduct, Long> {

}
