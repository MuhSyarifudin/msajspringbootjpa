package com.juaracoding.msajspringbootjpa.service;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 13/02/2023 22:49
@Last Modified 13/02/2023 22:49
Version 1.1
*/


import com.juaracoding.msajspringbootjpa.handler.ResourceNotFoundException;
import com.juaracoding.msajspringbootjpa.model.CategoryProduct;
import com.juaracoding.msajspringbootjpa.repo.CategoryProductRepo;
import com.juaracoding.msajspringbootjpa.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryProductService {
    private CategoryProductRepo categoryProductRepo;


    @Autowired
    public CategoryProductService(CategoryProductRepo categoryProductRepo) {
        this.categoryProductRepo = categoryProductRepo;
    }


    public void saveDataCategory(CategoryProduct categoryProduct){
//        if(categoryProduct.getNameCategoryProduct().equals("") || categoryProduct.getNameCategoryProduct()==null)
//        {
//            if(categoryProduct.getNameCategoryProduct().length()>40)
//            {
//
//            }
//        }
//        if(categoryProduct.getStrDescCategoryProduct().equals("") || categoryProduct.getStrDescCategoryProduct()==null)
//        {
//
//        }
        categoryProductRepo.save(categoryProduct);
    }

    public void saveAllCategory(List<CategoryProduct> listCategoryProduct){
        categoryProductRepo.saveAll(listCategoryProduct);
    }

    @Transactional
    public void updateCategory(CategoryProduct categoryProduct,Long id) throws  Exception
    {
        CategoryProduct cProduct = categoryProductRepo.findById(id).orElseThrow (
                ()->  new ResourceNotFoundException(ConstantMessage.WELCOME_MESSAGE)
        );

        /*
            SELECT * FROM MstCategoryProduct WHERE IDCategoryProduct = ?
            cProduct.getNameCategoryProduct();//ALAT ELEKTRONIK
            cProduct.getStrDescCategoryProduct();//seluruh peralatan yang disentuh nanti nyetrum
         */
        if(cProduct!=null){
            cProduct.setNameCategoryProduct(categoryProduct.getNameCategoryProduct());
            cProduct.setModifiedBy(categoryProduct.getModifiedBy());
            cProduct.setModifiedDate(new Date());
            cProduct.setStrDescCategoryProduct(categoryProduct.getStrDescCategoryProduct());
        }

    }

    public List<CategoryProduct> findAllCategory()
    {
        return categoryProductRepo.findAll();
        /*
            SELECT * FROM MstCategoryProduct
         */
    }
    public Page<CategoryProduct> findAllCategoryByPage(Pageable pageable)
    {
        return categoryProductRepo.findAll(pageable);
        /*
            SELECT * FROM MstCategoryProduct Page = ? , Sort = ? , Record = ?

            totalRecord = 100
            page = 0
            Record = 10
            data balikan = dari index ke 0 s.d index ke 9

            page = 1
            record = 10
            data balikan = dari index 10 s.d index 19

            page = 2
            record = 10
            data balikan = dari index 20 s.d index 19

         */
    }

    public Optional<CategoryProduct> findById(Long id)
    {
        return categoryProductRepo.findById(id);

        /*
            SELECT * FROM MstCategoryProduct WHERE IDCategoryProduct = ?
         */
    }


}
