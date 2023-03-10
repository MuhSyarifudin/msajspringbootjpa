package com.juaracoding.msajspringbootjpa.service;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 13/02/2023 22:49
@Last Modified 13/02/2023 22:49
Version 1.1
*/


import com.juaracoding.msajspringbootjpa.configuration.OtherConfig;
import com.juaracoding.msajspringbootjpa.handler.ResourceNotFoundException;
import com.juaracoding.msajspringbootjpa.handler.ResponseHandler;
import com.juaracoding.msajspringbootjpa.model.CategoryProduct;
import com.juaracoding.msajspringbootjpa.repo.CategoryProductRepo;
import com.juaracoding.msajspringbootjpa.utils.ConstantMessage;
import com.juaracoding.msajspringbootjpa.utils.LoggingFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CategoryProductService {



    private CategoryProductRepo categoryProductRepo;
    private String [] strExceptionArr = new String[2];



    @Autowired
    public CategoryProductService(CategoryProductRepo categoryProductRepo) {
        strExceptionArr[0] = "CategoryProductService";
        this.categoryProductRepo = categoryProductRepo;
    }


    @Transactional(rollbackFor = Exception.class)
    public void saveDataCategory(CategoryProduct categoryProduct){

        categoryProductRepo.save(categoryProduct);

    }

    @Transactional(rollbackFor = Exception.class)
    public void saveAllCategory(List<CategoryProduct> listCategoryProduct){
        categoryProductRepo.saveAll(listCategoryProduct);
    }

    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public ResponseEntity<Object> saveUploadFile(List<CategoryProduct> listCategoryProduct,
                                                 MultipartFile multipartFile,
                                                 WebRequest request) throws ResourceNotFoundException {
        List<CategoryProduct> categoryProductList = null;
        String strMessage = ConstantMessage.SUCCESS_SAVE;
        try
        {
            categoryProductList = categoryProductRepo.saveAll(listCategoryProduct);
            if(categoryProductList.size()==0)
            {
//                strExceptionArr[1]="saveUploadFile(List<CategoryProduct> listCategoryProduct, MultipartFile multipartFile, WebRequest request)---LINE67";
//                LoggingFile.exceptionStringz(strExceptionArr,new ResourceNotFoundException(ConstantMessage.ERROR_EMPTY_FILE +" -- "+multipartFile.getOriginalFilename()), OtherConfig.getFlagLogging());
                return new ResponseHandler().generateResponse(ConstantMessage.ERROR_EMPTY_FILE +" -- "+multipartFile.getOriginalFilename(),
                        HttpStatus.BAD_REQUEST,null,"FI01020",request);
            }
        }
        catch (Exception e)
        {
            strMessage = e.getMessage();
            strExceptionArr[1]="saveUploadFile(List<CategoryProduct> listCategoryProduct, MultipartFile multipartFile, WebRequest request) --- LINE 77";
            LoggingFile.exceptionStringz(strExceptionArr,e, OtherConfig.getFlagLogging());
            return new ResponseHandler().generateResponse(strMessage,
                    HttpStatus.BAD_REQUEST,null,"FI01021",request);
        }

        return new ResponseHandler().generateResponse(strMessage,
                HttpStatus.CREATED,null,null,request);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateCategory(CategoryProduct categoryProduct,Long id) throws  Exception
    {
        CategoryProduct cProduct = categoryProductRepo.findById(id).orElseThrow (
                ()->  new ResourceNotFoundException("Data tidak ditemukan")
        );

        /*
            SELECT * FROM MstCategoryProduct WHERE IDCategoryProduct = ?
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
