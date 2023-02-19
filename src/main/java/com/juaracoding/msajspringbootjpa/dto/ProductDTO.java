package com.juaracoding.msajspringbootjpa.dto;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 17/02/2023 20:56
@Last Modified 17/02/2023 20:56
Version 1.1
*/
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.juaracoding.msajspringbootjpa.model.CategoryProduct;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private Long idProduct;
    private String nameProduct;
    private CategoryProductDTO categoryProductDTO;
    private CategoryProduct categoryProduct;
    private String descriptionProduct;

    public Long getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public CategoryProductDTO getCategoryProductDTO() {
        return categoryProductDTO;
    }

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setCategoryProductDTO(CategoryProductDTO categoryProductDTO) {
        this.categoryProductDTO = categoryProductDTO;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }
}
