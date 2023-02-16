package com.juaracoding.msajspringbootjpa.service;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 16/02/2023 21:25
@Last Modified 16/02/2023 21:25
Version 1.1
*/
import com.juaracoding.msajspringbootjpa.configuration.OtherConfig;
import com.juaracoding.msajspringbootjpa.handler.ResponseHandler;
import com.juaracoding.msajspringbootjpa.model.Product;
import com.juaracoding.msajspringbootjpa.repo.ProductRepo;
import com.juaracoding.msajspringbootjpa.utils.ConstantMessage;
import com.juaracoding.msajspringbootjpa.utils.LoggingFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    private ProductRepo productRepo;
    private String [] strExceptionArr = new String[2];

    @Autowired
    public ProductService(ProductRepo productRepo) {
        strExceptionArr[0] = "ProductService";
        this.productRepo = productRepo;
    }

    public ResponseEntity<Object> saveProduct(Product product)
    {
        String strMessage = ConstantMessage.SUCCESS_SAVE;
        try
        {
            productRepo.save(product);
        }
        catch (Exception e)
        {
            strExceptionArr[1]="saveProduct(Product product) --- LINE 38";
            LoggingFile.exceptionStringz(strExceptionArr,e, OtherConfig.getFlagLogging());
            return new ResponseHandler().generateResponse(ConstantMessage.ERROR_SAVE_FAILED,
                    HttpStatus.BAD_REQUEST,null,"FI01001",null);
        }

        return new ResponseHandler().generateResponse(strMessage,
                HttpStatus.CREATED,null,null,null);
    }

}
