package com.juaracoding.msajspringbootjpa.controller;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 19/02/2023 8:38
@Last Modified 19/02/2023 8:38
Version 1.1
*/

import com.juaracoding.msajspringbootjpa.configuration.OtherConfig;
import com.juaracoding.msajspringbootjpa.handler.ResourceNotFoundException;
import com.juaracoding.msajspringbootjpa.handler.ResponseHandler;
import com.juaracoding.msajspringbootjpa.model.CategoryProduct;
import com.juaracoding.msajspringbootjpa.model.Provinsi;
import com.juaracoding.msajspringbootjpa.repo.ProvinsiRepo;
import com.juaracoding.msajspringbootjpa.service.ProvinsiService;
import com.juaracoding.msajspringbootjpa.utils.ConstantMessage;
import com.juaracoding.msajspringbootjpa.utils.ExcelReader;
import com.juaracoding.msajspringbootjpa.utils.LoggingFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/prov/")
public class ProvinsiController {
    private ProvinsiService provinsiService;
    private String [] strExcep = new String[2];
    List<Provinsi> ProvUpload = new ArrayList<Provinsi>();

    @Autowired
    public ProvinsiController(ProvinsiService provinsiService) {
        this.provinsiService = provinsiService;
    }

    @PostMapping("/v1/uplxls/batch")
    public ResponseEntity<Object> uploadExcelMaster(@Valid
                                                    @RequestParam("fileXlsx")
                                                    @RequestHeader MultipartFile multipartFile,
                                                    WebRequest request
    ) throws Exception {

        if(ExcelReader.isExcel(multipartFile))
        {
            return provinsiService.saveUploadFile(
                    excelToProvinsi(multipartFile.getInputStream()),
                    multipartFile,
                    request);
        }
        else
        {
            return new ResponseHandler().generateResponse(ConstantMessage.ERROR_NOT_EXCEL_FILE+" -- "+multipartFile.getOriginalFilename(),
                    HttpStatus.NOT_ACCEPTABLE,null,"FI01021",request);
        }
    }

    public List<Provinsi> excelToProvinsi(InputStream inputStream) throws Exception {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        Iterator<Row> rows = sheet.iterator();

        ProvUpload.clear();
        int intCatchErrorRecord = 0;
        int intNextCell = 0;

        try {

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                Iterator<Cell> cellsInRow = currentRow.iterator();

                if(intCatchErrorRecord!=0){
                    intNextCell = 0;

                    Provinsi Prov = new Provinsi();

                    while (cellsInRow.hasNext()) {
                        Cell currentCell = cellsInRow.next();

                        if(intNextCell==0)
                        {
                            Prov.setNamaProvinsi(currentCell.getStringCellValue());
                        }
                        else if(intNextCell==1)
                        {
                            Prov.setSingkatan(currentCell.getStringCellValue());
                        }
                        else if(intNextCell==2)
                        {
                            Prov.setLat(currentCell.getStringCellValue());
                        }
                        else if(intNextCell==3)
                        {
                            Prov.setLon(currentCell.getStringCellValue());
                        }
                        else if(intNextCell==4)
                        {
                            Prov.setNamaPemimpin(currentCell.getStringCellValue());
                        }
                        else
                        {
                            Prov.setCreatedBy(currentCell.getStringCellValue());
                        }

                        intNextCell++;
                    }
                    ProvUpload.add(Prov);
                }
                intCatchErrorRecord++;
            }

        } catch (Exception ex) {
            throw new Exception(ex.getMessage()+" Error Record at Line "+intCatchErrorRecord);
        }
        finally
        {
            workbook.close();
        }
        return ProvUpload;
    }

}
