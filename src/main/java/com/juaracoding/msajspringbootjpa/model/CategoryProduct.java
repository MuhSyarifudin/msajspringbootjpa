package com.juaracoding.msajspringbootjpa.model;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 13/02/2023 20:23
@Last Modified 13/02/2023 20:23
Version 1.1
*/

import com.juaracoding.msajspringbootjpa.utils.ConstantMessage;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "MstCategoryProduct")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCategoryProduct")
    private Long idCategoryProduct;

    @Length(message = ConstantMessage.WARNING_CATPROD_MAX_LENGTH_NAME, max = 40)
    @NotEmpty(message = ConstantMessage.WARNING_CATPROD_NAME_CANNOT_EMPTY)
    @Column(name = "NameCategoryProduct", nullable = false, length = 40)
    private String nameCategoryProduct;

    @NotEmpty(message = ConstantMessage.WARNING_CATPROD_DESC_CANNOT_EMPTY)
    @Length(message = ConstantMessage.WARNING_CATPROD_MAX_LENGTH_DESC, max = 500)
    @Column(name = "DescCategoryProduct", nullable = false, length = 500)
    private String strDescCategoryProduct;

    /*
        start audit trails
     */
    @Column(name ="CreatedDate")
    private Date createdDate = new Date();

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "ModifiedDate")
    private Date modifiedDate;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

    @Column(name = "IsDelete")
    private Byte isDelete = 1;
    /*
        end audit trails
     */

    public Long getIdCategoryProduct() {
        return idCategoryProduct;
    }

    public void setIdCategoryProduct(Long idCategoryProduct) {
        this.idCategoryProduct = idCategoryProduct;
    }

    public String getNameCategoryProduct() {
        return nameCategoryProduct;
    }

    public void setNameCategoryProduct(String nameCategoryProduct) {
        this.nameCategoryProduct = nameCategoryProduct;
    }

    public String getStrDescCategoryProduct() {
        return strDescCategoryProduct;
    }

    public void setStrDescCategoryProduct(String strDescCategoryProduct) {
        this.strDescCategoryProduct = strDescCategoryProduct;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}
