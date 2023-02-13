package com.juaracoding.msajspringbootjpa.controller;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 13/02/2023 22:43
@Last Modified 13/02/2023 22:43
Version 1.1
*/

import com.juaracoding.msajspringbootjpa.model.CategoryProduct;
import com.juaracoding.msajspringbootjpa.service.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/mgmnt")
public class CategoryProductController {
    private CategoryProductService categoryProductService;

    @Autowired
    public CategoryProductController(CategoryProductService categoryProductService) {
        this.categoryProductService = categoryProductService;
    }

    @PostMapping("/v1/s")
    public void saveCategory(@Valid
                             @RequestBody CategoryProduct categoryProduct
    ){

        categoryProductService.saveDataCategory(categoryProduct);

    }
    @PostMapping("/v1/sl")
    public void saveCategoryList(@Valid
                                 @RequestBody List<CategoryProduct> listCategoryProduct
    ){

        categoryProductService.saveAllCategory(listCategoryProduct);

    }

    @PostMapping("/v1/sl/{id}")
    public void updateCategoryById(@Valid
                                   @RequestBody CategoryProduct categoryProduct,
                                   @PathVariable Long id
    ) throws Exception {

        categoryProductService.updateCategory(categoryProduct,id);
    }

}
