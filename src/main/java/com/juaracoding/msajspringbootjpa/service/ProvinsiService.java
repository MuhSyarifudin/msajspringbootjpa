package com.juaracoding.msajspringbootjpa.service;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 19/02/2023 8:41
@Last Modified 19/02/2023 8:41
Version 1.1
*/

import com.juaracoding.msajspringbootjpa.handler.ResourceNotFoundException;
import com.juaracoding.msajspringbootjpa.handler.ResponseHandler;
import com.juaracoding.msajspringbootjpa.model.Provinsi;
import com.juaracoding.msajspringbootjpa.repo.ProvinsiRepo;
import com.juaracoding.msajspringbootjpa.utils.ConstantMessage;
import com.juaracoding.msajspringbootjpa.utils.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ProvinsiService {

    private ProvinsiRepo provinsiRepo;
    private String [] strExcep = new String[2];

    @Autowired
    public ProvinsiService(ProvinsiRepo provinsiRepo) {
        strExcep[0] = "ProvinsiService";
        this.provinsiRepo = provinsiRepo;
    }

    @Transactional(rollbackFor = {Exception.class,SQLException.class})
    public ResponseEntity<Object> saveUploadFile(List<Provinsi> listProvinsi,
                                                        MultipartFile multipartFile,
                                                        WebRequest request) throws ResourceNotFoundException {
        List<Provinsi> provinsiList = null;
        String strMessage = ConstantMessage.SUCCESS_SAVE;
        try
        {
            provinsiList = provinsiRepo.saveAll(listProvinsi);
            if(provinsiList.size()==0)
            {
                return new ResponseHandler().generateResponse(ConstantMessage.ERROR_EMPTY_FILE +" -- "+multipartFile.getOriginalFilename(),
                        HttpStatus.BAD_REQUEST,null,"FI01020",request);
            }
        }
        catch (Exception e)
        {
            strMessage = e.getMessage();
            return new ResponseHandler().generateResponse(strMessage,
                    HttpStatus.BAD_REQUEST,null,"FI01021",request);
        }

        return new ResponseHandler().generateResponse(strMessage,
                HttpStatus.CREATED,null,null,request);
    }

}
